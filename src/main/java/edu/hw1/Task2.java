package edu.hw1;

import java.util.logging.Logger;

public class Task2 {
    private final long number;

    public Task2(long number) {
        this.number = number;
    }

    public int numbersQuantity() {
        long absNumber = Math.abs(number);
        int count = 0;
        do {
            count++;
            absNumber /= 10;
        } while (absNumber > 0);
        return count;
    }

}

class Check2 {
    public static void main(String[] args) {
        final Logger LOGGER = Logger.getLogger(Task0.class.getName());

        Task2 task2 = new Task2(100);

        LOGGER.info(String.valueOf(task2.numbersQuantity()));
    }
}
