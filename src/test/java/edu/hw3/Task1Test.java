package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.encode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    @DisplayName("Строка является null") public void testNullInputString() {
        // given
        String inputString = null;

        // expected
        assertThrows(RuntimeException.class, () -> encode(inputString));
    }

    @Test
    @DisplayName("Строка является пустой") public void testEmptyInputString() {
        // given
        String inputString = "";

        // expected
        assertThrows(RuntimeException.class, () -> encode(inputString));
    }

    @Test
    @DisplayName("Подается строка из чисел") public void testNumberInputString() {
        // given
        String inputString = "12345";

        // when
        String resultString = encode(inputString);
        // expected
        assertEquals(inputString, resultString);
    }

    @Test
    @DisplayName("Подается строка из кириллицы") public void testRussianSymbolsInputString() {
        // given
        String inputString = "абвгд";

        // when
        String resultString = encode(inputString);
        // expected
        assertEquals(inputString, resultString);
    }

    @Test
    @DisplayName("Подается валидная строка из латиницы") public void testLatinSymbolsInputString() {
        // given
        String inputString = "Hello world!";
        String expectedString = "Svool dliow!";
        // when
        String resultString = encode(inputString);
        // expected
        assertEquals(expectedString, resultString);
    }
}
