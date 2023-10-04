package edu.hw1;

import java.util.logging.Logger;

public class Task5 {
    private final long number;
    private long absNumber;

    public Task5(long number) {
        this.number = number;
        absNumber = Math.abs(number);
    }

    public boolean numberCheckup() {
        if (absNumber <= Long.MAX_VALUE
            && String.valueOf(absNumber).length() % 2 == 0) {
            return isPalindrome();
        } else {
            return false;
        }
    }

    private boolean isPalindrome() {
        while (String.valueOf(absNumber).length() >= 2) {
            if (!String.valueOf(absNumber).equals(new StringBuilder(String.valueOf(absNumber)).reverse().toString())) {
                makeOffspring();
            } else {
                return true;
            }
        }
        return false;
    }

    private void makeOffspring() {
        char[] digits = String.valueOf(absNumber).toCharArray();
        String newNumber = "";
        for (int i = 0; i < digits.length; i += 2) {
            newNumber += ((long) digits[i] - '0' + (long) digits[i + 1] - '0');
        }
        absNumber = Long.parseLong(newNumber);
    }

}