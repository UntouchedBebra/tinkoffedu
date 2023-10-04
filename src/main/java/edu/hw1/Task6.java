package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private final String KAPREKAR_CONST = "6174";
    private final int LOWEST_BOUNDARY = 1000;
    private final int MAX_DIGITS_COUNT = 4;
    private final int number;
    private String stringNumber;
    private int iterationsCount;

    public Task6(int number) {
        this.number = number;
        this.stringNumber = String.valueOf(number);
        iterationsCount = 1;
    }

    public int numberProcessing() {
        if (number > LOWEST_BOUNDARY
            && number <= Integer.MAX_VALUE
            && !allDigitsAreSimilar()) {
            return Kaprekar(stringNumber);
        } else {
            return -1;
        }
    }

    private boolean allDigitsAreSimilar() {
        char[] digits = stringNumber.toCharArray();
        char symbol = digits[0];
        for (int i = 1; i < digits.length; i++) {
            if (symbol != digits[i]) {
                return false;
            }
        }
        return true;
    }

    private int Kaprekar(String number) {
        String difference = getDifference(number);
        if (!difference.equals(KAPREKAR_CONST)) {
            iterationsCount++;
            Kaprekar(difference);
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
