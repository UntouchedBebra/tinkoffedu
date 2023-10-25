package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackwardIteratorTest {
    @Test
    @DisplayName("Подается пустой лист")
    void testEmptyInputList() {
        // given
        List<String> inputEmptyList = new ArrayList<>();
        Iterator<String> backwardIterator = new BackwardIterator<>(inputEmptyList);

        // expected
        assertFalse(backwardIterator.hasNext());
    }

    @Test
    public void testIteratorWithNonEmptyList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = new BackwardIterator<>(list);

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertFalse(iterator.hasNext());
    }
}
