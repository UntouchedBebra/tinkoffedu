package edu.hw3.task4;

public enum ArabicNumber {
    ONE(1),
    FOUR(4),
    FIVE(5),
    NINE(9),
    TEN(10),
    FOURTY(40),
    FIFTY(50),
    NINETY(90),
    HUNDRED(100),
    FOUR_HUNDRED(400),
    FIVE_HUNDRED(500),
    NINE_HUNDRED(900),
    THOUSAND(1000);

    private final int value;

    ArabicNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
