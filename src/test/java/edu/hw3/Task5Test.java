package edu.hw3;

import edu.hw3.task5.Contact;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.task5.Task5.parseContacts;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    @DisplayName("Подается null-массив строк") void testNullinputContactsArray() {
        // given
        String[] inputArray = null;
        String order = "asc";

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> parseContacts(inputArray, order));

    }

    @Test
    @DisplayName("Подается пустой массив строк") void testEmptyinputContactsArray() {
        // given
        String[] inputArray = new String[] {};
        String order = "asc";

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> parseContacts(inputArray, order));

    }

    @Test
    @DisplayName("Подается массив с null-строкой внутри") void testInternalNullStringInArray() {
        // given
        String[] inputArray = new String[] {"Thomas Gun", null};
        String order = "asc";

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> parseContacts(inputArray, order));
    }

    @Test
    @DisplayName("Подается неверный порядок") void testInvalidOrder() {
        // given
        String[] inputArray = new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String order = "bebra";

        // expected
        Assertions.assertThrows(RuntimeException.class, () -> parseContacts(inputArray, order));
    }

    @Test
    @DisplayName("\"ASC\" Сортировка с полными данными") void testFirstValidDataWithAscSort() {
        // given
        String[] inputArray = new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String inputOrder = "asc";

        List<Contact> expectedList = Arrays.asList(
            new Contact("Thomas Aquinas"),
            new Contact("Rene Descartes"),
            new Contact("David Hume"),
            new Contact("John Locke")
        );

        // expected
        assertEquals(expectedList.toString(), parseContacts(inputArray, inputOrder).toString());
    }

    @Test
    @DisplayName("\"DESC\" Сортировка с полными данными") void testFirstValidDataWithDescSort() {
        // given
        String[] inputArray = new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String inputOrder = "desc";

        List<Contact> expectedList = Arrays.asList(
            new Contact("John Locke"),
            new Contact("David Hume"),
            new Contact("Rene Descartes"),
            new Contact("Thomas Aquinas")
        );

        // expected
        assertEquals(expectedList.toString(), parseContacts(inputArray, inputOrder).toString());
    }

    @Test
    @DisplayName("\"DESC\" Сортировка с частичными данными") void testFirstPartialValidDataWithAscSort() {
        // given
        String[] inputArray = new String[] {"A", "B", "C", "D"};
        String inputOrder = "desc";

        List<Contact> expectedList = Arrays.asList(
            new Contact("D"),
            new Contact("C"),
            new Contact("B"),
            new Contact("A")
        );

        // expected
        assertEquals(expectedList.toString(), parseContacts(inputArray, inputOrder).toString());
    }
}
