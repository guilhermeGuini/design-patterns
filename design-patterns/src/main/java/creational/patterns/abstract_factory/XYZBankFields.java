package creational.patterns.abstract_factory;

import static creational.patterns.abstract_factory.TypeField.NUMBER;
import static creational.patterns.abstract_factory.TypeField.TEXT;

public enum XYZBankFields {

    HEADER_BANK_CODE(5, NUMBER, true),
    HEADER_CURRENT_DATE_HOUR(14, TEXT, false),

    BATCH_HEADER_BANK_CODE(5, NUMBER, true),
    BATCH_HEADER_PAYMENT_TYPE(8, TEXT, false),
    BATCH_HEADER_PAYMENT_FILL_BLANK(6, TEXT, false),

    DETAILS_BANK_CODE(5, NUMBER, true),
    DETAILS_PAYMENT_VALUE(8, NUMBER, true),
    DETAILS_PAYMENT_ENTRY_DATE(6, TEXT, true),

    BATCH_TRAILER_BANK_CODE(5, NUMBER, true),
    BATCH_TRAILER_AMOUNT_PAYMENTS(6, NUMBER, true),
    BATCH_TRAILER_AMOUNT_VALUE(8, NUMBER, true),

    TRAILER_BANK_CODE(5, NUMBER, true),
    TRAILER_NUMBER_OF_BATCHS(8, NUMBER, true),
    TRAILER_FILL_BLANK(6, TEXT, true);

    private int size;
    private TypeField type;
    private boolean leftPadding;

    XYZBankFields(int size, TypeField type, boolean leftPadding) {
        this.size = size;
        this.type = type;
        this.leftPadding = leftPadding;
    }

    public int getSize() {
        return size;
    }

    public TypeField getType() {
        return type;
    }

    public boolean isLeftPadding() {
        return leftPadding;
    }

}
