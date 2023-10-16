package projectone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final HashSet<String> wordsToGuess;
    private final Random random;

    public Dictionary(HashSet<String> wordsArray) {
        wordsToGuess = new HashSet<>(wordsArray);
        random = new Random();
    }

    public String getRandomWord() {
        List<String> wordsToGuessList = new ArrayList<>(wordsToGuess);
        int randomIndex = random.nextInt(wordsToGuessList.size());
        return wordsToGuessList.get(randomIndex);
    }

}
