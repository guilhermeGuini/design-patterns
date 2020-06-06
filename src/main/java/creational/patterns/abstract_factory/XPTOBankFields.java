package creational.patterns.abstract_factory;

import static creational.patterns.abstract_factory.TypeField.*;

public enum XPTOBankFields {

    HEADER_BANK_CODE(5, NUMBER, true),
    HEADER_CURRENT_DATE(8, TEXT, false),

    BATCH_HEADER_BANK_CODE(5, NUMBER, true),
    BATCH_HEADER_PAYMENT_TYPE(8, TEXT, false),

    DETAILS_BANK_CODE(5, NUMBER, true),
    DETAILS_PAYMENT_VALUE(8, NUMBER, true),

    BATCH_TRAILER_BANK_CODE(5, NUMBER, true),
    BATCH_TRAILER_AMOUNT_VALUE(8, NUMBER, true),

    TRAILER_BANK_CODE(5, NUMBER, true),
    TRAILER_NUMBER_OF_BATCHS(8, NUMBER, true);

    private int size;
    private TypeField type;
    private boolean leftPadding;

    XPTOBankFields(int size, TypeField type, boolean leftPadding) {
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
