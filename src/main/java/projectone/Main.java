package projectone;

import static projectone.HangmanUI.extractWordsFromInputString;
import static projectone.HangmanUI.fillingOutTheDictionaryMessage;
import static projectone.HangmanUI.gameStartedMessage;
import static projectone.HangmanUI.getInputString;

final public class Main {

    private Main() {
    }

    public static void main(String[] args) {
        fillingOutTheDictionaryMessage();
        HangmanApp session = new HangmanApp(
            extractWordsFromInputString(getInputString(
                "Enter some words in the line separated by a space:",
                "Typed line is empty | doesn't consist any letters.\nRepeat the input:"
            )));
        gameStartedMessage();
        session.gameProcess();
    }

}
