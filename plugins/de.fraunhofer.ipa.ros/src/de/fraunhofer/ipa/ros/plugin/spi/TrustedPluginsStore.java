package de.fraunhofer.ipa.ros.plugin.spi;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Read-only loader for the user's {@code trusted-plugins.json} approval store.
 *
 * <p>Format:
 * {@code {"version":1,"approved":[{"sha256":"<hex>","fileName":"...","id":"...","approvedAt":"..."}]}}.
 * Matching is strictly by {@code sha256}; {@code fileName} and {@code id} are used only to classify
 * modified JARs as {@code "changed"} and for UI display.
 */
final class TrustedPluginsStore {

    private static final Pattern SHA256_HEX = Pattern.compile("^[0-9a-f]{64}$");

    record ApprovedEntry(String sha256, String fileName, String id, String approvedAt) {
    }

    static final class Snapshot {
        private final boolean valid;
        private final boolean missing;
        private final String notice;
        private final List<ApprovedEntry> entries;
        private final Set<String> approvedSha256s;
        private final Set<String> approvedFileNames;
        private final Set<String> approvedIds;

        private Snapshot(
                final boolean valid,
                final boolean missing,
                final String notice,
                final List<ApprovedEntry> entries) {
            this.valid = valid;
            this.missing = missing;
            this.notice = notice == null ? "" : notice;
            this.entries = List.copyOf(entries);
            Set<String> shas = new LinkedHashSet<>();
            Set<String> files = new LinkedHashSet<>();
            Set<String> ids = new LinkedHashSet<>();
            for (ApprovedEntry entry : entries) {
                shas.add(entry.sha256());
                if (!entry.fileName().isEmpty()) {
                    files.add(entry.fileName());
                }
                if (!entry.id().isEmpty()) {
                    ids.add(entry.id());
                }
            }
            this.approvedSha256s = Set.copyOf(shas);
            this.approvedFileNames = Set.copyOf(files);
            this.approvedIds = Set.copyOf(ids);
        }

        static Snapshot missing(final String notice) {
            return new Snapshot(false, true, notice, List.of());
        }

        static Snapshot invalid(final String notice) {
            return new Snapshot(false, false, notice, List.of());
        }

        static Snapshot of(final List<ApprovedEntry> entries) {
            return new Snapshot(true, false, "", entries);
        }

        boolean valid() {
            return valid;
        }

        boolean missing() {
            return missing;
        }

        String notice() {
            return notice;
        }

        boolean isShaApproved(final String sha256) {
            return valid && sha256 != null && !sha256.isEmpty() && approvedSha256s.contains(sha256);
        }

        String approvalStateFor(final String sha256, final String fileName, final String labelId) {
            if (isShaApproved(sha256)) {
                return "approved";
            }
            if ((fileName != null && !fileName.isEmpty() && approvedFileNames.contains(fileName))
                    || (labelId != null && !labelId.isEmpty() && approvedIds.contains(labelId))) {
                return "changed";
            }
            return "unapproved";
        }
    }

    private TrustedPluginsStore() {
    }

    static Snapshot load(final Path path) {
        if (path == null || !Files.exists(path)) {
            return Snapshot.missing(
                    "Plugin approval file not found at '" + path + "'; no external plugin JARs are approved.");
        }
        String raw;
        try {
            raw = Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException | SecurityException e) {
            return Snapshot.invalid(
                    "Plugin approval file could not be read; no external plugin JARs are approved.");
        }

        try {
            Object parsed = new JsonParser(raw).parseDocument();
            if (!(parsed instanceof Map<?, ?> root)) {
                return Snapshot.invalid("Plugin approval file is invalid; no external plugin JARs are approved.");
            }
            Object versionObj = root.get("version");
            if (!(versionObj instanceof Number num) || num.doubleValue() != 1.0) {
                return Snapshot.invalid("Plugin approval file is invalid; no external plugin JARs are approved.");
            }
            Object approvedObj = root.get("approved");
            if (!(approvedObj instanceof List<?> rawList)) {
                return Snapshot.invalid("Plugin approval file is invalid; no external plugin JARs are approved.");
            }
            List<ApprovedEntry> entries = new ArrayList<>();
            for (Object item : rawList) {
                if (!(item instanceof Map<?, ?> map)) {
                    return Snapshot.invalid("Plugin approval file is invalid; no external plugin JARs are approved.");
                }
                String sha = asString(map.get("sha256")).trim().toLowerCase();
                if (!SHA256_HEX.matcher(sha).matches()) {
                    return Snapshot.invalid("Plugin approval file is invalid; no external plugin JARs are approved.");
                }
                String fileName = asString(map.get("fileName")).trim();
                String id = asString(map.get("id")).trim();
                String approvedAt = asString(map.get("approvedAt")).trim();
                entries.add(new ApprovedEntry(sha, fileName, id, approvedAt));
            }
            return Snapshot.of(entries);
        } catch (RuntimeException e) {
            return Snapshot.invalid("Plugin approval file is invalid; no external plugin JARs are approved.");
        }
    }

    static String computeFileSha256(final Path file) throws IOException {
        MessageDigest digest = newSha256Digest();
        byte[] buf = new byte[8192];
        try (InputStream is = Files.newInputStream(file)) {
            int n;
            while ((n = is.read(buf)) != -1) {
                digest.update(buf, 0, n);
            }
        }
        return toHex(digest.digest());
    }

    static String sha256Hex(final byte[] bytes) {
        MessageDigest digest = newSha256Digest();
        digest.update(bytes);
        return toHex(digest.digest());
    }

    private static MessageDigest newSha256Digest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 MessageDigest unavailable", e);
        }
    }

    private static String toHex(final byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(Character.forDigit((b >>> 4) & 0xF, 16));
            sb.append(Character.forDigit(b & 0xF, 16));
        }
        return sb.toString();
    }

    private static String asString(final Object v) {
        return v instanceof String s ? s : "";
    }

    private static final class JsonParser {
        private final String src;
        private int pos;

        JsonParser(final String src) {
            this.src = src == null ? "" : src;
        }

        Object parseDocument() {
            skipWhitespace();
            Object val = parseValue();
            skipWhitespace();
            if (pos != src.length()) {
                throw new IllegalArgumentException("Unexpected trailing content at index " + pos);
            }
            return val;
        }

        private Object parseValue() {
            skipWhitespace();
            if (pos >= src.length()) {
                throw new IllegalArgumentException("Unexpected end of JSON");
            }
            char c = src.charAt(pos);
            return switch (c) {
                case '{' -> parseObject();
                case '[' -> parseArray();
                case '"' -> parseString();
                case 't' -> parseLiteral("true", Boolean.TRUE);
                case 'f' -> parseLiteral("false", Boolean.FALSE);
                case 'n' -> parseLiteral("null", null);
                default -> parseNumber();
            };
        }

        private Map<String, Object> parseObject() {
            expect('{');
            Map<String, Object> map = new LinkedHashMap<>();
            skipWhitespace();
            if (peek('}')) {
                pos++;
                return map;
            }
            while (true) {
                skipWhitespace();
                String key = parseString();
                skipWhitespace();
                expect(':');
                Object val = parseValue();
                map.put(key, val);
                skipWhitespace();
                if (peek(',')) {
                    pos++;
                } else if (peek('}')) {
                    pos++;
                    return map;
                } else {
                    throw new IllegalArgumentException("Expected ',' or '}' at " + pos);
                }
            }
        }

        private List<Object> parseArray() {
            expect('[');
            List<Object> list = new ArrayList<>();
            skipWhitespace();
            if (peek(']')) {
                pos++;
                return list;
            }
            while (true) {
                list.add(parseValue());
                skipWhitespace();
                if (peek(',')) {
                    pos++;
                } else if (peek(']')) {
                    pos++;
                    return list;
                } else {
                    throw new IllegalArgumentException("Expected ',' or ']' at " + pos);
                }
            }
        }

        private String parseString() {
            expect('"');
            StringBuilder sb = new StringBuilder();
            while (pos < src.length()) {
                char c = src.charAt(pos++);
                if (c == '"') {
                    return sb.toString();
                }
                if (c < 0x20) {
                    throw new IllegalArgumentException("Unescaped control character in string");
                }
                if (c == '\\') {
                    if (pos >= src.length()) {
                        throw new IllegalArgumentException("Unterminated escape");
                    }
                    char esc = src.charAt(pos++);
                    switch (esc) {
                        case '"', '\\', '/' -> sb.append(esc);
                        case 'b' -> sb.append('\b');
                        case 'f' -> sb.append('\f');
                        case 'n' -> sb.append('\n');
                        case 'r' -> sb.append('\r');
                        case 't' -> sb.append('\t');
                        case 'u' -> {
                            if (pos + 4 > src.length()) {
                                throw new IllegalArgumentException("Incomplete unicode escape");
                            }
                            sb.append((char) Integer.parseInt(src.substring(pos, pos + 4), 16));
                            pos += 4;
                        }
                        default -> throw new IllegalArgumentException("Invalid escape \\" + esc);
                    }
                } else {
                    sb.append(c);
                }
            }
            throw new IllegalArgumentException("Unterminated string");
        }

        private Object parseLiteral(final String lit, final Object val) {
            if (!src.startsWith(lit, pos)) {
                throw new IllegalArgumentException("Expected " + lit + " at " + pos);
            }
            pos += lit.length();
            return val;
        }

        private Number parseNumber() {
            int start = pos;
            if (pos < src.length() && src.charAt(pos) == '-') {
                pos++;
            }
            if (pos >= src.length() || !Character.isDigit(src.charAt(pos))) {
                throw new IllegalArgumentException("Invalid number at " + start);
            }
            while (pos < src.length() && Character.isDigit(src.charAt(pos))) {
                pos++;
            }
            if (pos < src.length() && src.charAt(pos) == '.') {
                pos++;
                if (pos >= src.length() || !Character.isDigit(src.charAt(pos))) {
                    throw new IllegalArgumentException("Invalid fraction at " + pos);
                }
                while (pos < src.length() && Character.isDigit(src.charAt(pos))) {
                    pos++;
                }
            }
            if (pos < src.length() && (src.charAt(pos) == 'e' || src.charAt(pos) == 'E')) {
                pos++;
                if (pos < src.length() && (src.charAt(pos) == '+' || src.charAt(pos) == '-')) {
                    pos++;
                }
                if (pos >= src.length() || !Character.isDigit(src.charAt(pos))) {
                    throw new IllegalArgumentException("Invalid exponent at " + pos);
                }
                while (pos < src.length() && Character.isDigit(src.charAt(pos))) {
                    pos++;
                }
            }
            return Double.valueOf(src.substring(start, pos));
        }

        private void skipWhitespace() {
            while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) {
                pos++;
            }
        }

        private boolean peek(final char c) {
            return pos < src.length() && src.charAt(pos) == c;
        }

        private void expect(final char c) {
            if (pos >= src.length() || src.charAt(pos) != c) {
                throw new IllegalArgumentException("Expected '" + c + "' at " + pos);
            }
            pos++;
        }
    }
}
