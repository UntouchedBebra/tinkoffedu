package edu.hw1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    private static Task7 task7;

    @BeforeAll
    static void classInit() {
        task7 = new Task7();
    }

    @DisplayName("Сдвиг вправо на положительный шаг")
    @Test
    void testPositiveShiftRight() {
        // given
        int number = 8;
        int shift = 1;
        // when
        int result = task7.rotateRight(number, shift);
        // then
        assertEquals(4, result);
    }
    @DisplayName("Сдвиг вправо на отрицательный шаг")
    @Test
    void testNegativeShiftRight() {
        // given
        int number = 8;
        int shift = -1;
        // when
        int result = task7.rotateRight(number, shift);
        // then
        assertEquals(1, result);
    }
    @DisplayName("Сдвиг вправо на положительный шаг")
    @Test
    void testPositiveShiftLeft() {
        // given
        int number = 8;
        int shift = 1;
        // when
        int result = task7.rotateLeft(number, shift);
        // then
        assertEquals(1, result);
    }
    @DisplayName("Сдвиг вправо на отрицательный шаг")
    @Test
    void testNegativeShiftLeft() {
        // given
        int number = 8;
        int shift = -1;
        // when
        int result = task7.rotateLeft(number, shift);
        // then
        assertEquals(4, result);
    }

    @DisplayName("Сдвиг вправо на нулевой шаг")
    @Test
    void testZeroMoveRight() {
        // given
        int number = 8;
        int shift = 0;
        // when
        int result = task7.rotateRight(number, shift);
        // then
        assertEquals(8, result);
    }

    @DisplayName("Сдвиг вправо на нулевой шаг")
    @Test
    void testZeroMoveLeft() {
        // given
        int number = 8;
        int shift = 0;
        // when
        int result = task7.rotateLeft(number, shift);
        // then
        assertEquals(8, result);
    }

    @DisplayName("Сдвиг вправо на большее число шагов, чем битов в числе")
    @Test
    void testStepsRightOverBits() {
        // given
        int number = 8;
        int shift = 5;
        // when
        int result = task7.rotateRight(number, shift);
        // then
        assertEquals(4, result);
    }

    @DisplayName("Сдвиг вправо на большее число шагов, чем битов в числе")
    @Test
    void testStepsLefttOverBits() {
        // given
        int number = 8;
        int shift = 5;
        // when
        int result = task7.rotateLeft(number, shift);
        // then
        assertEquals(1, result);
    }

    @DisplayName("Сдвиг вправо числа 0")
    @Test
    void testStepsRightFromZero() {
        // given
        int number = 0;
        int shift = 10;
        // when
        int result = task7.rotateLeft(number, shift);
        // then
        assertEquals(0, result);
    }
    @DisplayName("Сдвиг вправо числа 1")
    @Test
    void testStepsRightFromOne() {
        // given
        int number = 1;
        int shift = 10;
        // when
        int result = task7.rotateLeft(number, shift);
        // then
        assertEquals(1, result);
    }







}

