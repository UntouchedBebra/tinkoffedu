package edu.hw1;

import java.util.logging.Logger;

public class Task7 {
    private String translateIntoBits(int number) {
        StringBuilder bitString = new StringBuilder();
        while (number > 0) {
            bitString.append(number % 2);
            number /= 2;
        }
        return bitString.reverse().toString();
    }

    public int rotateRight(int number, int shift) {
        number = Math.abs(number);
        if (shift > 0) {
            char[] initialBitsArray = translateIntoBits(number).toCharArray();

            char[] shiftedArray = new char[initialBitsArray.length];
            final int truncation = initialBitsArray.length;

            for (int i = 0; i < initialBitsArray.length; i++) {
                int newIndex = (i + shift) % truncation;
                shiftedArray[newIndex] = initialBitsArray[i];
            }
            return translateIntoNumber(shiftedArray);
        } else if (shift < 0) {
            return rotateLeft(number, Math.abs(shift));
        } else {
            return number;
        }
    }

    public int rotateLeft(int number, int shift) {
        number = Math.abs(number);
        if (shift > 0) {
            char[] initialBitsArray = translateIntoBits(number).toCharArray();

            char[] shiftedArray = new char[initialBitsArray.length];
            final int truncation = initialBitsArray.length;

            for (int i = 0; i < initialBitsArray.length; i++) {
                int newIndex = (i - shift) >= 0 ? (i - shift) : initialBitsArray.length + ((i - shift) % truncation);
                shiftedArray[newIndex] = initialBitsArray[i];
            }

            return translateIntoNumber(shiftedArray);
        } else if (shift < 0) {
            return rotateRight(number, Math.abs(shift));
        } else {
            return number;
        }
    }

    private int translateIntoNumber(char[] bitsArray) {
        int resultNumber = 0;
        int pow = 0;
        final int powConstant = 2;
        for (int i = bitsArray.length - 1; i >= 0; i--) {
            resultNumber += (bitsArray[i] == '1') ? (int) Math.pow(powConstant, pow) : 0;
            pow++;
        }
        return resultNumber;
    }
}
