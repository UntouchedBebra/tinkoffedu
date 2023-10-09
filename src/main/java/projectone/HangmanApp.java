package projectone;

import java.util.HashSet;
import static projectone.HangmanUI.extractLetterFromInputString;
import static projectone.HangmanUI.getInputString;

public class HangmanApp {
    private final Dictionary dictionary;
    private final HangmanWord hangmanWord;
    public final static int MAX_ATTEMPTS_COUNT = 10;
    private int currentAttempts;

    public HangmanApp(HashSet<String> words) {
        dictionary = new Dictionary(words);
        hangmanWord = new HangmanWord(dictionary.getRandomWord());
        currentAttempts = 0;
    }

    public void gameProcess() {
        while (hangmanWord.wordNotComposed() && currentAttempts < MAX_ATTEMPTS_COUNT) {

            boolean guessIsRight = hangmanWord.guessLetter(extractLetterFromInputString(getInputString(
                "\"Type a letter: \"",
                "Typed line is empty | doesn't consist any words.\nRepeat the input:"
            )));
        }
    }

}
