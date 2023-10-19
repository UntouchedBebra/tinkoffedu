package projectone;

import java.util.HashSet;
import static projectone.HangmanUI.correctGuessMessage;
import static projectone.HangmanUI.defeatMessage;
import static projectone.HangmanUI.extractLetterFromInputString;
import static projectone.HangmanUI.getInputString;
import static projectone.HangmanUI.incorrectGuessMessage;
import static projectone.HangmanUI.winningMessage;

public class HangmanApp {
    private final HangmanWord hangmanWord;
    public static final int MAX_ATTEMPTS_COUNT = 10;
    private int usedAttemptsCount;

    public HangmanApp(HashSet<String> words) {
        Dictionary dictionary = new Dictionary(words);
        hangmanWord = new HangmanWord(dictionary.getRandomWord());
        usedAttemptsCount = 0;
    }

    public void gameProcess() {
        while (hangmanWord.wordNotComposed() && usedAttemptsCount < MAX_ATTEMPTS_COUNT) {

            boolean guessIsRight = hangmanWord.guessLetter(extractLetterFromInputString(getInputString(
                "\"Type a letter: \"",
                "Typed line is empty | doesn't consist any letters.\nRepeat the input:"
            )));

            if (guessIsRight) {
                correctGuessMessage(hangmanWord.getCurrentWordStatement());
            } else {
                incorrectGuessMessage(MAX_ATTEMPTS_COUNT - (++usedAttemptsCount));
            }
        }

        if (hangmanWord.wordNotComposed()) {
            defeatMessage();
        } else {
            winningMessage();
        }
    }



}
