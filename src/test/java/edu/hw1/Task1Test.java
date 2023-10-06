package edu.hw1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class Task1Test {
    private Task1 task1;

    @DisplayName("Корректное время в формате mm:ss")
    @Test
    void correctTime() {
        // given
        String videoLength = "10:30";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(630, result);
    }

    @DisplayName("Корректное время с незначащими нулями в обеих частях")
    @Test
    void insignificantZerosWithCorrectTime() {
        // given
        String videoLength = "00000001:00000030";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(90, result);
    }

    @DisplayName("Некорректное время без незначащих нулей в одной из части")
    @Test
    void absenceOfInsingificantZerosWithCorrectTime() {
        // given
        String videoLength = "1:00000030";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(-1, result);
    }


    @DisplayName("Корректное время с минутами превышающими 60")
    @Test
    void exceedingOfMinutes() {
        // given
        String videoLength = "100:01";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(6001, result);
    }

    @DisplayName("Некорректное время с секундами превышающими 60")
    @Test
    void exceedingOfSeconds() {
        // given
        String videoLength = "100:100";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("null-строка")
    @Test
    void testNullVideoLength() {
        // given
        String videoLength = null;
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Пустая строка")
    @Test
    void testEmptyVideoLength() {
        // given
        String videoLength = "";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Пустая строка")
    @Test
    void testOnlyColonInVideoLength() {
        // given
        String videoLength = " : ";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Строка с рандомными символами без \':\'")
    @Test
    void randomSymbolsWithoutColon() {
        // given
        String videoLength = "dwqwqwqddwqdwqd";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Строка с рандомными символами с \':\'")
    @Test
    void randomSymbolsWithColon() {
        // given
        String videoLength = "dwqwqwq:ddwqdwqd";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(-1, result);
    }

    @DisplayName("Длительность 00:00")
    @Test
    void zeroSecondsAndMinutes() {
        // given
        String videoLength = "00:00";
        task1 = new Task1(videoLength);
        // when
        int result = task1.stringProcessing();
        // then
        assertEquals(0, result);
    }







}
