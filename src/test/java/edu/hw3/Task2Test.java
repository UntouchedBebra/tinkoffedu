package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static edu.hw3.Task2.getBalancedClustersStack;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    @DisplayName("Подается null строка")
    void testNullInputString() {
        // given
        String inputString = null;

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> getBalancedClustersStack(inputString));
    }

    @Test
    @DisplayName("Подается пустая строка")
    void testEmptyInputString() {
        // given
        String inputString = "";

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> getBalancedClustersStack(inputString));
    }

    @Test
    @DisplayName("Подается строка без скобок")
    void testInputStringWithoutAnyBrackets() {
        // given
        String inputString = "abcefg";

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> getBalancedClustersStack(inputString));
    }

    @Test
    @DisplayName("Подается строка без возможности кластеризации")
    void testStringWithoutClusteringPossibility() {
        // given
        String inputString = ")(";

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> getBalancedClustersStack(inputString));
    }

    @Test
    @DisplayName("Подается валидная строка")
    public void testValidInputString() {
        String input = "((()))()(()())";
        ArrayList<String> expected = new ArrayList<>();
        expected.add("((()))");
        expected.add("()");
        expected.add("(()())");

        ArrayList<String> result = Task2.getBalancedClustersStack(input);

        assertEquals(expected.size(), result.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

}
