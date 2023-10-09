package projectone;


import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

public final class HangmanUI {
    private final static Logger LOGGER = Logger.getLogger(HangmanUI.class.getName());

    private HangmanUI() {
    }

    public static void fillingOutTheDictionaryMessage() {
        LOGGER.info("Let's fill in the dictionary!");
    }

    public static void gameStartedMessage() {
        LOGGER.info("Game has been started!");
    }

    public static String getInputString(String inputMessage, String errorMessage) {

        LOGGER.info(inputMessage);

        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        inputString = dataInput(scanner, inputString);

        while (!inputStringIsCorrect(inputString)) {
            LOGGER.info(errorMessage);
            inputString = scanner.nextLine().toLowerCase();
        }

        return inputString;
    }

    @NotNull private static String dataInput(Scanner scanner, String inputString) {
        String inputStringCopy = inputString;
        if (scanner.hasNextLine()) {
            inputStringCopy = scanner.nextLine().toLowerCase();
        } else {
            LOGGER.info("You've given up early!");
            System.exit(0);
        }
        return inputStringCopy;
    }

    public static HashSet<String> extractWordsFromInputString(String inputString) {

        StringBuilder wordsWithWhitespaces = new StringBuilder();
        for (char symbol : inputString.toCharArray()) {
            if (symbol == ' ' || (symbol >= 'a' && symbol <= 'z')) {
                wordsWithWhitespaces.append(symbol);
            } else {
                wordsWithWhitespaces.append(" ");
            }

        }

        HashSet<String> words = new HashSet<>();
        for (String word : wordsWithWhitespaces.toString().split(" ")) {
            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        return words;
    }

    public static char extractLetterFromInputString(String inputString) {
        for (char symbol : inputString.toCharArray()) {
            if (symbol >= 'a' && symbol <= 'z') {
                return symbol;
            }
        }
        return ' ';
    }

    public static void correctGuessMessage(String currentWordStatement) {
        LOGGER.info(String.format("Hit!\nThe word: %s", currentWordStatement));
    }

    public static void incorrectGuessMessage(int usedAttemptsCount) {
        LOGGER.info(String.format("\"Missed. You've got %d attempts left",
            HangmanApp.MAX_ATTEMPTS_COUNT - usedAttemptsCount
        ));
    }

    public static void winningMessage() {
        LOGGER.info("You've won :) Congratulations!");
    }

    public static void defeatMessage() {
        LOGGER.info("You've lost :( Don't upset!");
    }

    private static boolean inputStringIsCorrect(String inputString) {
        return !isNull(inputString) && !inputString.isEmpty() && consistLetters(inputString);
    }

    private static boolean isNull(String inputString) {
        return inputString == null;
    }

    private static boolean consistLetters(String inputString) {
        for (char symbol : inputString.toCharArray()) {
            if (symbol >= 'a' && symbol <= 'z') {
                return true;
            }
        }
        return false;
    }

}
