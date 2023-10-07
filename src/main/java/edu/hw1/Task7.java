package edu.hw1;

public class Task7 {
    private String translateIntoBits(int number) {
        int num = number;
        StringBuilder bitString = new StringBuilder();
        while (num > 0) {
            bitString.insert(0, num % 2);
            num /= 2;
        }
        return bitString.toString();
    }

    public int rotateCycleRight(int number, int shift) {
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
            return rotateCycleLeft(num, Math.abs(shift));
        } else {
            return num;
        }
    }

    public int rotateCycleLeft(int number, int shift) {
        int num = number;
        num = Math.abs(num);
        if (shift > 0) {
            char[] initialBitsArray = translateIntoBits(num).toCharArray();

            char[] shiftedArray = new char[initialBitsArray.length];
            final int truncation = initialBitsArray.length;

            for (int i = 0; i < initialBitsArray.length; i++) {
                int newIndex = (i - shift) % truncation >= 0 ? (i - shift) % truncation
                    :
                    initialBitsArray.length + ((i - shift) % truncation);
                shiftedArray[newIndex] = initialBitsArray[i];
            }
            return translateIntoNumber(shiftedArray);
        } else if (shift < 0) {
            return rotateCycleRight(num, Math.abs(shift));
        } else {
            return num;
        }
    }

    private int translateIntoNumber(char[] bitsArray) {
        int resultNumber = 0;
        for (int i = bitsArray.length - 1; i >= 0; i--) {
            if (bitsArray[i] == ('1')) {
                resultNumber += 1 << (bitsArray.length - 1 - i);
            }
        }
        return resultNumber;
    }
}
