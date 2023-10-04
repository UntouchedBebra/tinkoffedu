package edu.hw1;

public class Task2 {
    private final long number;
    private static final int TRANCATION_VALUE = 10;

    public Task2(long number) {
        this.number = number;
    }

    public int numbersQuantity() {
        long absNumber = Math.abs(number);
        int count = 0;
        do {
            count++;
            absNumber /= TRANCATION_VALUE;
        } while (absNumber > 0);
        return count;
    }

}

