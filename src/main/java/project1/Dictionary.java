package project1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final HashSet<String> wordsToGuess;

    public Dictionary(HashSet<String> wordsArray) {
        wordsToGuess = new HashSet<>(wordsArray);
    }

    public String getRandomWord() {
            List<String> wordsToGuessList = new ArrayList<>(wordsToGuess);
            Random random = new Random();
            int randomIndex = random.nextInt(wordsToGuessList.size());
            return wordsToGuessList.get(randomIndex);
    }

}
