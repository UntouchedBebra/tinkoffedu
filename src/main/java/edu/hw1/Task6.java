package edu.hw1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task6 {
    private static final String KAPREKAR_CONSTANT = "6174";
    private static final int LOW_BOUNDARY = 1000;
    private static final int TOP_BOUNDARY = 9999;
    private static final int MAX_DIGITS_COUNT = 4;
    private static final int ONLY_ONE_DIGIT_NUMBER = 1;
    private final int number;
    private final String stringNumber;
    private int iterationsCount;

    public Task6(int number) {
        this.number = number;
        this.stringNumber = String.valueOf(number);
        iterationsCount = 1;
    }

    public int numberProcessing() {
        if (number == Integer.parseInt(KAPREKAR_CONSTANT)) {
            return 0;
        } else {
            if (number > LOW_BOUNDARY
                && number <= TOP_BOUNDARY
                && allDigitsNotSimilar()) {
                return kaprekar(stringNumber);
            } else {
                return -1;
            }
        }
    }

    private boolean allDigitsNotSimilar() {
        Set<Character> digits = new HashSet<>();
        for (char digit : stringNumber.toCharArray()) {
            digits.add(digit);
        }
        return digits.size() != ONLY_ONE_DIGIT_NUMBER;
    }

    private int kaprekar(String number) {
        String difference = getDifference(number);
        if (!difference.equals(KAPREKAR_CONSTANT)) {
            iterationsCount++;
            kaprekar(difference);
        }
        return iterationsCount;
    }

    private String getDifference(String number) {
        char[] digits = number.toCharArray();
        Arrays.sort(digits);
        int sortedUpNumbers = Integer.parseInt(new String(digits));
        int sortedDownNumbers = Integer.parseInt(new StringBuilder(String.valueOf(digits)).reverse().toString());
        int difference = sortedDownNumbers - sortedUpNumbers;
        StringBuilder stollenZeros = new StringBuilder();
        for (int i = 0; i < MAX_DIGITS_COUNT - String.valueOf(difference).length(); i++) {
            stollenZeros.append('0');
        }
        return stollenZeros.toString() + difference;
    }
}
