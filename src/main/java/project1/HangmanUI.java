package project1;

import org.jetbrains.annotations.NotNull;
import java.util.HashSet;
import java.util.Scanner;

public class HangmanUI {

//    final String[] hangmanStatements = {
//        "    +---+\n"
//        + "    |   |\n"
//        + "        |\n"
//        + "        |\n"
//        + "        |\n"
//        + "        |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "    O   |\n"
//        + "        |\n"
//        + "        |\n"
//        + "        |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "    O   |\n"
//        + "    |   |\n"
//        + "        |\n"
//        + "        |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "    O   |\n"
//        + "   /|   |\n"
//        + "        |\n"
//        + "        |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "    O   |\n"
//        + "   /|\\  |\n"
//        + "        |\n"
//        + "        |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "    O   |\n"
//        + "   /|\\  |\n"
//        + "    |   |\n"
//        + "        |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "    O   |\n"
//        + "   /|\\  |\n"
//        + "    |   |\n"
//        + "   /    |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "    O   |\n"
//        + "   /|\\\\  |\n"
//        + "    |   |\n"
//        + "   / \\  |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "   [O   |\n"
//        + "   /|\\  |\n"
//        + "    |   |\n"
//        + "   / \\  |\n"
//        + "=========\n",
//
//        "    +---+\n"
//        + "    |   |\n"
//        + "   [O]  |\n"
//        + "   /|\\  |\n"
//        + "    |   |\n"
//        + "   / \\  |\n"
//        + "=========\n"
//
//    };

    public static String getInputString(String inputMessage, String errorMessage) {

        System.out.println(inputMessage);

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().toLowerCase();

        while (!inputStringIsCorrect(inputString)) {
            System.out.println(errorMessage);
            inputString = scanner.nextLine().toLowerCase();
        }

        scanner.close();
        return inputString;
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
