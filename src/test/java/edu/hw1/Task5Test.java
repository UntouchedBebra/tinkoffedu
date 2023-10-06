package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    private Task5 task5;

    @DisplayName("Четное число цифр и палиндром")
    @Test
    void testEvenNumberOfSymbolAndPalindrome() {
        // given
        long number = 1331;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertTrue(result);
    }
    @DisplayName("Нечетное число цифр и палиндром")
    @Test
    void testOddNumberOfSymbolAndPalindrome() {
        // given
        long number = 131;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertTrue(result);
    }
    @DisplayName("Отрицательное число с четным кол-вом цифр и палиндром")
    @Test
    void testNegativeEvenNumberOfSymbolAndPalindrome() {
        // given
        long number = -1331;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertTrue(result);
    }
    @DisplayName("Отрицательное число с нечетным кол-вом цифр и палиндром")
    @Test
    void testNegativeOddNumberOfSymbolAndPalindrome() {
        // given
        long number = -131;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertTrue(result);
    }

    @DisplayName("Одна цифра")
    @Test
    void testSingleSymbolInNumber() {
        // given
        long number = 0;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertTrue(result);
    }

    @DisplayName("Потомок является палиндромом")
    @Test
    void testOffspringIsPalindrome() {
        // given
        long number = 11211230;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertTrue(result);
    }

    @DisplayName("Потомок не является палиндромом")
    @Test
    void testOffspringNotPalindrome() {
        // given
        long number = 12345;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertFalse(result);
    }

    @DisplayName("Отрицательное число с четным кол-вом цифр и не палиндром")
    @Test
    void testNegativeNumberWithEvenQuantityOfSymbolsNotPalindrome() {
        // given
        long number = -12345678;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertFalse(result);
    }

    @DisplayName("Отрицательное число с нечетным кол-вом цифр и не палиндром")
    @Test
    void testNegativeNumberWithOddQuantityOfSymbolsNotPalindrome() {
        // given
        long number = -123456789;
        task5 = new Task5(number);
        // when
        boolean result = task5.numberCheckup();
        // then
        assertFalse(result);
    }

}
