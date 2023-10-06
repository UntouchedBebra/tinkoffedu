package edu.hw1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class Task2Test {
    private Task2 task2;

    @DisplayName("Положительное число")
    @Test
    void testPositiveNumberCounting() {
        // given
        int number = 12345;
        task2 = new Task2(number);
        // when
        int result = task2.numbersQuantity();
        // then
        assertEquals(5, result);
    }

    @DisplayName("Отрицательное число")
    @Test
    void testNegativeNumberCounting() {
        // given
        int number = -12345;
        task2 = new Task2(number);
        // when
        int result = task2.numbersQuantity();
        // then
        assertEquals(5, result);
    }

    @DisplayName("Число 0")
    @Test
    void testZeroCounting() {
        // given
        int number = 0;
        task2 = new Task2(number);
        // when
        int result = task2.numbersQuantity();
        // then
        assertEquals(1, result);
    }

    @DisplayName("Число из одной цифры")
    @Test
    void testSingleDigitNumberCounting() {
        // given
        int number = 5;
        task2 = new Task2(number);
        // when
        int result = task2.numbersQuantity();
        // then
        assertEquals(1, result);
    }



}
