package projectone;

import java.util.HashSet;
import java.util.Set;

public class HangmanWord {
    private final String wordForGuessing;
    private final Set<Character> symbolsForGuessing;
    private final Set<Character> guessedSymbols;

    public HangmanWord(String randomWordFromWordDictionary) {
        wordForGuessing = randomWordFromWordDictionary;

        symbolsForGuessing = new HashSet<>();
        for (char symbol : wordForGuessing.toCharArray()) {
            symbolsForGuessing.add(symbol);
        }

        guessedSymbols = new HashSet<>();
    }

    public String getCurrentWordStatement() {
        if (!wordNotComposed()) {
            return wordForGuessing;
        } else {
            char[] wordSymbols = wordForGuessing.toCharArray();
            for (int i = 0; i < wordSymbols.length; i++) {
                wordSymbols[i] = letterIsGuessed(wordSymbols[i]) ? wordSymbols[i] : '*';
            }
            return new String(wordSymbols);
        }
    }

    private boolean letterIsGuessed(char letter) {
        return guessedSymbols.contains(letter);
    }

    public boolean guessLetter(char guessedSymbol) {
        if (symbolsForGuessing.contains(guessedSymbol)) {
            guessedSymbols.add(guessedSymbol);
            return true;
        }

        return false;
    }

    public boolean wordNotComposed() {
        return symbolsForGuessing.size() != guessedSymbols.size();
    }
}







