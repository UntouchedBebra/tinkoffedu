import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectone.Dictionary;

public class DictionaryTest {
    @DisplayName("Получение слова из пустого словаря")
    @Test void testGettingWordFromFilledDictionary() {
        // given
        Dictionary dictionary = new Dictionary(new HashSet(List.of("happiness")));
        // when
        String word = dictionary.getRandomWord();
        // then
        Assertions.assertEquals("happiness", word);
    }

}
