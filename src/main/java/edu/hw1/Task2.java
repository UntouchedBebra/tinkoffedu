package edu.hw1;

import java.util.logging.Logger;

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

    /**
     * Главный метод приложения для проверки подающихся чисел
     * Здесь происходит:
     * 1. Создание экземпляра класса Task2
     * 2. Выполняется обработка поданного числа
     * 3. Выводится результат ( количество цифр в числе )
     *
     * @param args Аргументы командной строки ( не используются )
     */
    public static void main(String[] args) {
        final Logger LOGGER = Logger.getLogger(Task0.class.getName());

        Task2 task2 = new Task2(Long.valueOf(100));

        LOGGER.info(String.valueOf(task2.numbersQuantity()));
    }
}

