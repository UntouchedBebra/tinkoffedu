package edu.hw3.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StockTest {

    @Test
    @DisplayName("null тикер")
    void testNullStockCode() {
        // expected
        assertThrows(StockException.class, () -> new Stock(null, 100));
    }

    @Test
    @DisplayName("Пустой тикер")
    void testEmptyStockCode() {
        // expected
        assertThrows(StockException.class, () -> new Stock("", 100));
    }

    @Test
    @DisplayName("Тикер с цифрами")
    void testStockCodeWithDigits() {
        // expected
        assertThrows(StockException.class, () -> new Stock("Alphabet123", 100));
    }

    @Test
    @DisplayName("Отрицательная стоимость")
    void testStockPriceIsBelowZero() {
        // expected
        assertThrows(StockException.class, () -> new Stock("SBER", -1));
    }

    @Test
    @DisplayName("Валидные данные")
    void testValidInputData() {
        // expected
        assertDoesNotThrow(() -> new Stock("SBER", 250));
    }

}
