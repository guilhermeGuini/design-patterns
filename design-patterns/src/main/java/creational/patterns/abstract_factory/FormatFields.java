package creational.patterns.abstract_factory;

import org.apache.commons.lang3.StringUtils;

class FormatFields {

    private FormatFields() {
        // do nothing
    }

    static String format(String value, int tam, TypeField typeField, boolean leftPadding) {

        String formattedValue = value;

        if (TypeField.NUMBER.equals(typeField)) {
            formattedValue = formattedValue.replaceAll("\\.", "");
        }

        if (leftPadding) {
            return StringUtils.leftPad(formattedValue, tam, typeField.getCharPadding());
        } else {
            return StringUtils.rightPad(formattedValue, tam, typeField.getCharPadding());
        }
    }
}
