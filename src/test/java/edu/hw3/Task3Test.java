package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static edu.hw3.Task3.getFrequencyDictionary;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    @DisplayName("Подается null-список")
    void testNullInputList() {
        // given
        List<String> inputList = null;

        // expected
        assertThrows(RuntimeException.class, () -> getFrequencyDictionary(inputList));

    }

    @Test
    @DisplayName("Подается пустой список")
    void testEmptyList() {
        // given
        List<String> inputList = new ArrayList<>();

        // expected
        assertThrows(RuntimeException.class, () -> getFrequencyDictionary(inputList));

    }

    @Test
    @DisplayName("Подается список с разными элементами")
    void testMultipleDifferentElements() {
        // given
        List<String> inputList = new ArrayList<>();
        inputList.add("a");
        inputList.add("b");
        inputList.add("a");

        // when
        Map<String, Integer> result = getFrequencyDictionary(inputList);

        // then
        assertAll(
            () -> assertEquals(2, result.size(), "Размер словаря должен быть 2"),
            () -> assertEquals(2, result.get("a"), "Частота 'a' должна быть 2"),
            () -> assertEquals(1, result.get("b"), "Частота 'b' должна быть 1")
        );
    }
}
