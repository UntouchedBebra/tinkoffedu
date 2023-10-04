package edu.hw1;

import java.util.logging.Logger;

public class Task1 {
    private final String videoLength;
    private int[] parts;

    private final static int CONVERT_MINUTES_TO_SECONDS = 60;
    private final static int HIGHEST_BOUNDARY_OF_SECONDS = 59;

    public Task1(String videoLength) {
        this.videoLength = videoLength;
        parts = null;
    }

    public int stringProcessing() {
        // Проверка на пустоту строки, наличия символа ':'
        if (!videoLength.isEmpty() && videoLength.contains(":") && stringCheckup()) {
            return parts[0] * CONVERT_MINUTES_TO_SECONDS + parts[1];
        } else {
            return -1;
        }

    }

    private boolean stringCheckup() {
        return checkPartsAreNumbers() && checkNumbersArePositiveOrZero() && boundariesAreFollowed() &&
            rightPartIsLessSixty();
    }

    private boolean checkPartsAreNumbers() throws NumberFormatException, ArrayIndexOutOfBoundsException {
        try {
            String[] stringParts = videoLength.split(":");
            parts = new int[2];
            for (int i = 0; i < 2; i++) {
                parts[i] = Integer.parseInt(stringParts[i]);
            }
            return true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean boundariesAreFollowed() {
        return (parts[0] <= Long.MAX_VALUE) && (parts[1] <= Long.MAX_VALUE);
    }

    private boolean checkNumbersArePositiveOrZero() {
        return (parts[0] >= 0) && (parts[1] >= 0);
    }

    private boolean rightPartIsLessSixty() {
        return parts[1] <= HIGHEST_BOUNDARY_OF_SECONDS;
    }

    /**
     * Главный метод приложения для проверки строк
     * Здесь происходит:
     * 1. Создание экземпляра класса Task1
     * 2. Выполняется обработка поданной строки
     * 3. Выводится результат
     *
     * @param args Аргументы командной строки ( не используются )
     */
    public static void main(String[] args) {

        final Logger LOGGER = Logger.getLogger(Task1.class.getName());

        Task1 task1 = new Task1("10:21");

        LOGGER.info(String.valueOf(task1.stringProcessing()));
    }

}

