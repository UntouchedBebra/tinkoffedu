package edu.hw1;

public class Task7 {
    private String translateIntoBits(int number) {
        int num = number;
        StringBuilder bitString = new StringBuilder();
        while (num > 0) {
            bitString.append(num % 2);
            num /= 2;
        }
        return bitString.reverse().toString();
    }

    public int rotateRight(int number, int shift) {
        int num = number;
        num = Math.abs(num);
        if (shift > 0) {
            char[] initialBitsArray = translateIntoBits(num).toCharArray();

            char[] shiftedArray = new char[initialBitsArray.length];
            final int truncation = initialBitsArray.length;

            for (int i = 0; i < initialBitsArray.length; i++) {
                int newIndex = (i + shift) % truncation;
                shiftedArray[newIndex] = initialBitsArray[i];
            }
            return translateIntoNumber(shiftedArray);
        } else if (shift < 0) {
            return rotateLeft(num, Math.abs(shift));
        } else {
            return num;
        }
    }

    public int rotateLeft(int number, int shift) {
        int num = number;
        num = Math.abs(num);
        if (shift > 0) {
            char[] initialBitsArray = translateIntoBits(num).toCharArray();

            char[] shiftedArray = new char[initialBitsArray.length];
            final int truncation = initialBitsArray.length;

            for (int i = 0; i < initialBitsArray.length; i++) {
                int newIndex = (i - shift) >= 0 ? (i - shift) : initialBitsArray.length + ((i - shift) % truncation);
                shiftedArray[newIndex] = initialBitsArray[i];
            }

            return translateIntoNumber(shiftedArray);
        } else if (shift < 0) {
            return rotateRight(num, Math.abs(shift));
        } else {
            return num;
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
