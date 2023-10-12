package edu.hw1;

import java.util.logging.Logger;

public class Task0 {
    private final Logger logger;

    public Task0() {
        logger = Logger.getLogger(Task0.class.getName());
    }

    public void printHelloWorld() {
        logger.info("Привет, мир!");
    }
}
