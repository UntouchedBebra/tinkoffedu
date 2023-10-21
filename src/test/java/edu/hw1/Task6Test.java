package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    Task6 task6;

    @DisplayName("Число больше верхней границы")
    @Test
    void testNumberIsBiggerThanTopBoundary() {
        // given
        int number = 10000;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Число меньше верхней границы")
    @Test
    void testNumberIsLessThanTopBoundary() {
        // given
        int number = 999;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Число с одинаковыми цифрами")
    @Test
    void testAllSymbolsAreSimilar() {
        // given
        int number = 5555;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Число уже постоянная Капрекара")
    @Test
    void testNumberIsAlreadyKaprekarConstant() {
        // given
        int number = 6174;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(0, result);
    }

    @DisplayName("Отрицательное число")
    @Test
    void testNegativeNumber() {
        // given
        int number = -1000;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Восстановление незначащих нулей при поиске разницы")
    @Test
    void testRestoreStollenZeros() {
        // given
        int number = 9998;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(5, result);
    }

    @DisplayName("1-ый пример из задания (3542)")
    @Test
    void testFirstTaskExample() {
        // given
        int number = 3542;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(3, result);
    }

    @DisplayName("2-ой пример из задания (6621)")
    @Test
    void testSecondTaskExample() {
        // given
        int number = 6621;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(5, result);
    }

    @DisplayName("3-ий пример из задания (6554)")
    @Test
    void testThirdTaskExample() {
        // given
        int number = 6554;
        task6 = new Task6(number);
        // when
        int result = task6.numberProcessing();
        // then
        assertEquals(4, result);
    }
}
