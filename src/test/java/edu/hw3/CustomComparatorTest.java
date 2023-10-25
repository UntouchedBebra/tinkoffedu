package edu.hw3;

import com.sun.jdi.IntegerType;
import edu.hw3.task7.CustomComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomComparatorTest {
    @Test
    @DisplayName("null-key в TreeMap")
    void testNullKeyTreeMap() {
        // given
        TreeMap<String, Integer> treeMap = new TreeMap<>(new CustomComparator());

        // when
        treeMap.put(null, 0);
        treeMap.put("one", 1);
        treeMap.put("two", 2);

        // then
        assertTrue(treeMap.containsKey(null));
    }
}
