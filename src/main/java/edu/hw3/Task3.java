package edu.hw3;

import java.util.HashMap;

public final class Task3 {
    private Task3() {

    }

    public static <T> HashMap<T, Integer> getFrequencyDictionary(T[] objects) {
        HashMap<T, Integer> frequencyDictionary = new HashMap<>();

        for (T object : objects) {
            if (frequencyDictionary.keySet().contains(object)) {
                int updatedWordFrequency = frequencyDictionary.get(object) + 1;
                frequencyDictionary.put(object, updatedWordFrequency);
            } else {
                frequencyDictionary.put(object, 1);
            }
        }
        return frequencyDictionary;
    }

}
