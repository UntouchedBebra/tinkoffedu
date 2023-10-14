package edu.hw1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Task4Test {
    Task4 task4;

    @DisplayName("Четное число символов")
    @Test
    void testEvenQuantityOfSymbols() {
        // given
        String str = "123456";
        task4 = new Task4(str);
        // when
        String result = task4.fixString();
        // then
        assertEquals("214365", result);
    }

    @DisplayName("Нечетное число символов")
    @Test
    void testOddQuantityOfSymbols() {
        // given
        String str = "badce";
        task4 = new Task4(str);
        // when
        String result = task4.fixString();
        // then
        assertEquals("abcde", result);
    }

    @DisplayName("Ссылка на null")
    @Test
    void testNullLinkInstead(){
        // given
        String str = null;
        task4 = new Task4(str);
        // when
        String result = task4.fixString();
        // then
        assertNull(result);
    }

    @DisplayName("Пустая строка")
    @Test
    void testEmptyString() {
        // given
        String str = "";
        task4 = new Task4(str);
        // when
        String result = task4.fixString();
        // then
        assertNull(result);
    }

    @DisplayName("Один символ")
    @Test
    void testSingleSymbolString() {
        // given
        String str = "q";
        task4 = new Task4(str);
        // when
        String result = task4.fixString();
        // then
        assertEquals("q", result);
    }

    @DisplayName("Два символа")
    @Test
    void testTwoSymbolsString() {
        // given
        String str = "qw";
        task4 = new Task4(str);
        // when
        String result = task4.fixString();
        // then
        assertEquals("wq", result);
    }
}
