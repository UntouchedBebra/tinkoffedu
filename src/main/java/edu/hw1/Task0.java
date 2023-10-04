package edu.hw1;

import java.util.logging.Logger;


public class Task0 {
    private static final Logger LOGGER = Logger.getLogger(Task0.class.getName());

    private Task0() {
        throw new AssertionError("Нет необходимости создавать объекты данного класс.");
    }

    public static void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }

    /**
     * Главный метод приложения для проверки вывода строки
     * Здесь происходит:
     * 1. Вывод строки "Привет, мир!"
     * @param args Аргументы командной строки ( не используются )
     */
    public static void main(String[] args) {
        Task0.printHelloWorld();
    }
}
