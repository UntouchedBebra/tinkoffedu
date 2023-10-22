package edu.hw3.task4;

import java.util.LinkedHashMap;
import static edu.hw3.task4.ArabicNumber.FIFTY;
import static edu.hw3.task4.ArabicNumber.FIVE;
import static edu.hw3.task4.ArabicNumber.FIVE_HUNDRED;
import static edu.hw3.task4.ArabicNumber.FOUR;
import static edu.hw3.task4.ArabicNumber.FOURTY;
import static edu.hw3.task4.ArabicNumber.FOUR_HUNDRED;
import static edu.hw3.task4.ArabicNumber.HUNDRED;
import static edu.hw3.task4.ArabicNumber.NINE;
import static edu.hw3.task4.ArabicNumber.NINETY;
import static edu.hw3.task4.ArabicNumber.NINE_HUNDRED;
import static edu.hw3.task4.ArabicNumber.ONE;
import static edu.hw3.task4.ArabicNumber.TEN;
import static edu.hw3.task4.ArabicNumber.THOUSAND;

public final class Task4 {
    private static final LinkedHashMap<Integer, String> ARABIC_TO_ROMAN_DICT;

    static {
        ARABIC_TO_ROMAN_DICT = new LinkedHashMap<>();
        ARABIC_TO_ROMAN_DICT.put(THOUSAND.getValue(), "M");
        ARABIC_TO_ROMAN_DICT.put(NINE_HUNDRED.getValue(), "CM");
        ARABIC_TO_ROMAN_DICT.put(FIVE_HUNDRED.getValue(), "D");
        ARABIC_TO_ROMAN_DICT.put(FOUR_HUNDRED.getValue(), "CD");
        ARABIC_TO_ROMAN_DICT.put(HUNDRED.getValue(), "C");
        ARABIC_TO_ROMAN_DICT.put(NINETY.getValue(), "XC");
        ARABIC_TO_ROMAN_DICT.put(FIFTY.getValue(), "L");
        ARABIC_TO_ROMAN_DICT.put(FOURTY.getValue(), "XL");
        ARABIC_TO_ROMAN_DICT.put(TEN.getValue(), "X");
        ARABIC_TO_ROMAN_DICT.put(NINE.getValue(), "IX");
        ARABIC_TO_ROMAN_DICT.put(FIVE.getValue(), "V");
        ARABIC_TO_ROMAN_DICT.put(FOUR.getValue(), "IV");
        ARABIC_TO_ROMAN_DICT.put(ONE.getValue(), "I");
    }

    private Task4() {

    }

    public static String getRomanNumber(int arabicNumber) {
        int number = arabicNumber;
        StringBuilder romanRepresentation = new StringBuilder();

        int subtrahendCountInNumber;
        for (int subtrahend : ARABIC_TO_ROMAN_DICT.keySet()) {
            while (number >= subtrahend) {
                romanRepresentation.append(ARABIC_TO_ROMAN_DICT.get(subtrahend));
                number -= subtrahend;
            }
        }
        return romanRepresentation.toString();
    }

}
