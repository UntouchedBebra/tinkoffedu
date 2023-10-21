package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    private Task8 task8;

    @DisplayName("null ссылка на матрицу")
    @Test
    void testNullMatrix() {
        // given
        task8 = new Task8(null);
        // when
        boolean result = task8.deskProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("Пустая матрица")
    @Test
    void testEmptyMatrix() {
        // given
        task8 = new Task8(new int[][] {});
        // when
        boolean result = task8.deskProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("null ссылки на одномерные массивы")
    @Test
    void testNullPointersAtSubarrays() {
        // given
        task8 = new Task8(new int[][] {
            null,
            null,
            null,
            {0, 0, 0, 0, 1, 0, 1, 0},
            null,
            null,
            null,
            {0, 0, 0, 0, 1, 0, 0, 0}
        });
        // when
        boolean result = task8.deskProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("Ссылки на пустые одномерные массивы")
    @Test
    void testPointersAtEmptySubarrays() {
        // given
        task8 = new Task8(new int[][] {
            {},
            {},
            {},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {},
            {},
            {},
            {0, 0, 0, 0, 1, 0, 0, 0}
        });
        // when
        boolean result = task8.deskProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("Использованы символы кроме 0 и 1")
    @Test
    void testOtherSymbolsOnTheDesk() {
        // given
        task8 = new Task8(new int[][] {
            {2, 2, 2, 1, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        });
        // when
        boolean result = task8.deskProcessing();
        // then
        assertFalse(result);
    }

    @DisplayName("Все кони в безопасности")
    @Test
    void testAllKnitsAreSafe() {
        // given
        task8 = new Task8(new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        }
        );
        // when
        boolean result = task8.deskProcessing();
        // then
        assertTrue(result);
    }

    @DisplayName("Какой-то из коней не в безопасности")
    @Test
    void testSoAndSoKnightNotSafe() {
        // given
        task8 = new Task8(new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        }
        );
        // when
        boolean result = task8.deskProcessing();
        // then
        assertFalse(result);
    }

}
