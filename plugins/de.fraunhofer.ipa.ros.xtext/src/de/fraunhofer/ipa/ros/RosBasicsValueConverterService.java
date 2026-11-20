package de.fraunhofer.ipa.ros;

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Value converters shared across Basics, Ros, Ros1, Ros2, and RosSystem DSLs.
 * Strips trailing colons from keyword-colon extension keys and unquotes quoted
 * extension keys/literals cleanly.
 */
public class RosBasicsValueConverterService extends Ecore2XtextTerminalConverters {

    @ValueConverter(rule = "ExtensionColonKey")
    public IValueConverter<String> ExtensionColonKey() {
        return new IValueConverter<String>() {
            @Override
            public String toValue(final String string, final INode node) throws ValueConverterException {
                if (string == null) {
                    return null;
                }
                return string.endsWith(":") ? string.substring(0, string.length() - 1) : string;
            }

            @Override
            public String toString(final String value) throws ValueConverterException {
                if (value == null) {
                    return null;
                }
                return value.endsWith(":") ? value : value + ":";
            }
        };
    }

    /** A name that lexed as a keyword added after main, such as {@code format:}; the value is the bare name. */
    @ValueConverter(rule = "AddedKeywordName")
    public IValueConverter<String> AddedKeywordName() {
        return ExtensionColonKey();
    }

    /** {@code package.Name}, quoted or not; the value is the unquoted name without spaces around the dots. */
    @ValueConverter(rule = "QualifiedRef")
    public IValueConverter<String> QualifiedRef() {
        return new IValueConverter<String>() {
            @Override
            public String toValue(final String string, final INode node) throws ValueConverterException {
                if (string == null) {
                    return null;
                }
                String trimmed = string.trim();
                if (trimmed.length() >= 2 && trimmed.startsWith("\"") && trimmed.endsWith("\"")) {
                    return trimmed.substring(1, trimmed.length() - 1);
                }
                return trimmed.replaceAll("\\s+", "");
            }

            @Override
            public String toString(final String value) throws ValueConverterException {
                if (value == null) {
                    return null;
                }
                return value.matches("[A-Za-z_][A-Za-z0-9_]*(\\.[A-Za-z_][A-Za-z0-9_]*)*") ? value : "\"" + value + "\"";
            }
        };
    }

    @ValueConverter(rule = "ExtensionKey")
    public IValueConverter<String> ExtensionKey() {
        return new IValueConverter<String>() {
            @Override
            public String toValue(final String string, final INode node) throws ValueConverterException {
                return unquoteIfQuoted(string);
            }

            @Override
            public String toString(final String value) throws ValueConverterException {
                return value;
            }
        };
    }

    @ValueConverter(rule = "ExtensionScalarLiteral")
    public IValueConverter<String> ExtensionScalarLiteral() {
        return new IValueConverter<String>() {
            @Override
            public String toValue(final String string, final INode node) throws ValueConverterException {
                if (node != null && node.getSemanticElement() instanceof ros.ExtensionScalarValue scalar) {
                    scalar.setRawKind(detectRawKind(string));
                }
                return unquoteIfQuoted(string);
            }

            @Override
            public String toString(final String value) throws ValueConverterException {
                return value;
            }
        };
    }

    private static String detectRawKind(final String raw) {
        if (raw == null) {
            return "string";
        }
        String trimmed = raw.trim();
        if (trimmed.length() >= 2
                && ((trimmed.startsWith("\"") && trimmed.endsWith("\""))
                        || (trimmed.startsWith("'") && trimmed.endsWith("'")))) {
            return "string";
        }
        if ("true".equals(trimmed) || "false".equals(trimmed)) {
            return "boolean";
        }
        try {
            Long.parseLong(trimmed);
            return "int";
        } catch (NumberFormatException ignored) {
        }
        try {
            Double.parseDouble(trimmed);
            return "double";
        } catch (NumberFormatException ignored) {
        }
        return "id";
    }

    private static String unquoteIfQuoted(final String raw) {
        if (raw == null || raw.length() < 2) {
            return raw;
        }
        char first = raw.charAt(0);
        char last = raw.charAt(raw.length() - 1);
        if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
            return raw.substring(1, raw.length() - 1);
        }
        return raw;
    }
}
