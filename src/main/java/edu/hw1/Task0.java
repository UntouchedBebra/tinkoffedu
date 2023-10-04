package edu.hw1;

import java.util.logging.Logger;

public class Task0 {
    private static final Logger LOGGER = Logger.getLogger(Task0.class.getName());

    public static void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }

    public static void main(String[] args) {
        Task0.printHelloWorld();
    }
}
