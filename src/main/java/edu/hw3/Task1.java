package edu.hw3;

import java.util.HashMap;

public final class Task1 {
    private static final HashMap<Character, Character> ATBASH_CIPHER_DICTIONARY;

    static {
        ATBASH_CIPHER_DICTIONARY = new HashMap<>();
        fillAtbashCodesDictionary();
    }

    private Task1() {
    }

    private static void fillAtbashCodesDictionary() {
        for (char currentCharacter = 'a'; currentCharacter <= 'z'; currentCharacter++) {
            Character scrambledLetter = (char) ('z' - (currentCharacter - 'a'));
            ATBASH_CIPHER_DICTIONARY.put(currentCharacter, scrambledLetter);
            ATBASH_CIPHER_DICTIONARY.put(
                Character.toUpperCase(currentCharacter),
                Character.toUpperCase(scrambledLetter)
            );
        }

    }

    public static String encode(String str) {
        StringBuilder scrambledString = new StringBuilder();
        for (char symbol : str.toCharArray()) {
            if (ATBASH_CIPHER_DICTIONARY.containsKey(symbol)) {
                scrambledString.append(ATBASH_CIPHER_DICTIONARY.get(symbol));
            } else {
                scrambledString.append(symbol);
            }
        }
        return scrambledString.toString();
    }

}
