package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.task4.Task4.getRomanNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @Test
    @DisplayName("Подается невалидное число > 3999")
    void testInputNumberIsBiggerThanUpperBoundary() {
        // given
        int inputNumber = 1_000_000;

        // expected
        assertThrows(RuntimeException.class, () -> getRomanNumber(inputNumber));
    }

    @Test
    @DisplayName("Подается невалидное число <1")
    void testInputNumberIsLowerThanLowerBoundary() {
        // given
        int inputNumber = 0;

        // expected
        assertThrows(RuntimeException.class, () -> getRomanNumber(inputNumber));
    }

    @Test
    @DisplayName("Подается валидное число (2999)")
    void testFirstValidInputNumber() {
        // given
        int inputNumber = 2999;
        String expectedRomanNumber = "MMCMXCIX";

        // when
        String actualRomanNumber = getRomanNumber(inputNumber);

        // then
        assertEquals(expectedRomanNumber, actualRomanNumber);
    }

    @Test
    @DisplayName("Подается валидное число (111)")
    void testSecondValidInputNumber() {
        // given
        int inputNumber = 111;
        String expectedRomanNumber = "CXI";

        // when
        String actualRomanNumber = getRomanNumber(inputNumber);

        // then
        assertEquals(expectedRomanNumber, actualRomanNumber);
    }
}
