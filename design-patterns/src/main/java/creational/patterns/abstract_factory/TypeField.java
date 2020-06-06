package creational.patterns.abstract_factory;

public enum TypeField {

    NUMBER('0'),
    TEXT(' ');

    private char charPadding;

    TypeField(char charPadding) {
        this.charPadding = charPadding;
    }

    public char getCharPadding() {
        return charPadding;
    }
}
