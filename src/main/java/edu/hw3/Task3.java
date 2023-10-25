package edu.hw3;

import java.util.HashMap;
import java.util.List;

public final class Task3 {
    private Task3() {

    }

    public static <T> HashMap<T, Integer> getFrequencyDictionary(List<T> objects) {
        if (isListValid(objects)) {
            HashMap<T, Integer> frequencyDictionary = new HashMap<>();

            for (T object : objects) {
                if (frequencyDictionary.containsKey(object)) {
                    int updatedWordFrequency = frequencyDictionary.get(object) + 1;
                    frequencyDictionary.put(object, updatedWordFrequency);
                } else {
                    frequencyDictionary.put(object, 1);
                }
            }
            return frequencyDictionary;
        } else {
            throw new RuntimeException("Создание частотного словаря невозможно");
        }
    }

    private static <T> boolean isListValid(List<T> list) {
        return list != null && !list.isEmpty();
    }

}
