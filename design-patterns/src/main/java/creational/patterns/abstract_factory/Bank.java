package creational.patterns.abstract_factory;

public enum Bank {

    XPTO(12345L),
    XYZ(98765L);

    private Long bankCode;

    Bank(Long bankCode) {
        this.bankCode = bankCode;
    }

    public Long getBankCode() {
        return bankCode;
    }
}
