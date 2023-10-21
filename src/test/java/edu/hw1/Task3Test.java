package edu.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Task3Test {
    private Task3 task3;

    @DisplayName("Один из массивов null")
    @Test void testOneOfArraysIsNull() {
        // given
        int[] firstArray = {1, 2, 3, 4};
        int[] secondArray = null;
        task3 = new Task3(firstArray, secondArray);
        // when
        boolean result = task3.arraysProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("Один из массивов пустой")
    @Test void testOneOfArraysIsEmpty() {
        // given
        int[] firstArray = new int[] {};
        int[] secondArray = {1, 2, 3, 4, 5};
        task3 = new Task3(firstArray, secondArray);
        // when
        boolean result = task3.arraysProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("Оба массива состоят из одного элемента")
    @Test void testOneElementArrays() {
        // given
        int[] firstArray = {1};
        int[] secondArray = {2};
        task3 = new Task3(firstArray, secondArray);
        // when
        boolean result = task3.arraysProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("Оба массива состоят из разных элементов и первый вкладывается во второй")
    @Test void testDifferentValuesInArrays() {
        // given
        int[] firstArray = {1, 2, 3, 4};
        int[] secondArray = {0, 6};
        task3 = new Task3(firstArray, secondArray);
        // when
        boolean result = task3.arraysProcessing();
        // then
        assertTrue(result);
    }

    @DisplayName("Оба массива состоят из разных элементов и первый не вкладывается во второй")
    @Test void testDifferentValuesInArraysAndFirstOneNotNestable() {
        // given
        int[] firstArray = {9, 9, 8};
        int[] secondArray = {8, 9};
        task3 = new Task3(firstArray, secondArray);
        // when
        boolean result = task3.arraysProcessing();
        // then
        assertFalse(result);
    }
}
