package edu.hw1;

public class Task1 {
    private final static int CONVERT_MINUTES_TO_SECONDS = 60;
    private final static int HIGHEST_BOUNDARY_OF_SECONDS = 59;
    private final String videoLength;
    private int[] parts;

    public Task1(String videoLength) {
        this.videoLength = videoLength;
        parts = null;
    }

    public int stringProcessing() {
        // Проверка на пустоту строки, наличия символа ':'
        if (videoLength != null
            && !videoLength.isEmpty()
            && containsColonAndTwoPartsExist()
            && partsLengthsAreBiggerThanTwo()
            && boundariesOfIntegerAreFollowedAndPartsAreNumbers()
            && numbersArePositiveOrZero()
            && rightPartIsLessSixty()) {
            return parts[0] * CONVERT_MINUTES_TO_SECONDS + parts[1];
        } else {
            return -1;
        }

    }

    private boolean containsColonAndTwoPartsExist() {
        return videoLength.contains(":") && videoLength.split(":").length == 2;
    }

    private boolean partsLengthsAreBiggerThanTwo() {
        String[] stringParts = videoLength.split(":");
        return stringParts[0].length() >= 2 && stringParts[1].length() >= 2;
    }

    private boolean boundariesOfIntegerAreFollowedAndPartsAreNumbers() {
        try {
            String[] stringParts = videoLength.split(":");
            parts = new int[2];
            for (int i = 0; i < 2; i++) {
                parts[i] = Integer.parseInt(stringParts[i]);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean numbersArePositiveOrZero() {
        return (parts[0] >= 0) && (parts[1] >= 0);
    }

    private boolean rightPartIsLessSixty() {
        return parts[1] <= HIGHEST_BOUNDARY_OF_SECONDS;
    }

}

