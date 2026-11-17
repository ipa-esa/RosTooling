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
                return unquoteIfQuoted(string);
            }

            @Override
            public String toString(final String value) throws ValueConverterException {
                return value;
            }
        };
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
