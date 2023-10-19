import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectone.HangmanUI;
import java.util.HashSet;

public class HangmanUITest {

    @DisplayName("Проверка пустой строки на пустоту и наличие латинских букв")
    @Test
    void testEmptyStringCheckup() {
        // given
        String inputString = "";
        // when
        boolean stringCheckup = HangmanUI.inputStringIsCorrect(inputString);
        // then
        Assertions.assertFalse(stringCheckup);
    }

    @DisplayName("Проверка строки из цифер на пустоту и наличие латинских букв")
    @Test
    void testDigitStringCheckup() {
        // given
        String inputString = "1242421";
        // when
        boolean stringCheckup = HangmanUI.inputStringIsCorrect(inputString);
        // then
        Assertions.assertFalse(stringCheckup);
    }

    @DisplayName("Проверка произвольной строки на пустоту и наличие латинских букв")
    @Test
    void testArtbitraryStringCheckup() {
        // given
        String inputString = "1242421sdqdqwdwq 4!@4214";
        // when
        boolean stringCheckup = HangmanUI.inputStringIsCorrect(inputString);
        // then
        Assertions.assertTrue(stringCheckup);
    }

    @DisplayName("Извлечение слова из строки с одним словом")
    @Test
    void testGettingWordFromSingleWordString() {
        // given
        String inputString = "son";
        HashSet<String> expectedWords = new HashSet<>();
        expectedWords.add("son");
        // when
        HashSet<String> extractedWords = HangmanUI.extractWordsFromInputString(inputString);
        // then
        Assertions.assertTrue(extractedWords.equals(expectedWords));
    }

    @DisplayName("Извлечение слова из строки с произвольными разделителями")
    @Test
    void testGettingWordFromArbitraryWordString() {
        // given
        String inputString = "son12345waitress 41!$*linen";
        HashSet<String> expectedWords = new HashSet<>();
        expectedWords.add("son");
        expectedWords.add("waitress");
        expectedWords.add("linen");
        // when
        HashSet<String> extractedWords = HangmanUI.extractWordsFromInputString(inputString);
        // then
        Assertions.assertTrue(extractedWords.equals(expectedWords));
    }

    @DisplayName("Извлечение буквы из строки с одной буквой")
    @Test
    void testGettingLetterFromSingleLetterString() {
        // given
        String inputString = "s";
        char expectedLetter = 's';
        // when
        char extractedLetter = HangmanUI.extractLetterFromInputString(inputString);
        // then
        Assertions.assertEquals(expectedLetter, extractedLetter);
    }

    @DisplayName("Извлечение буквы из произвольной строки")
    @Test
    void testGettingLetterFromArbitraryWordString() {
        // given
        String inputString = "47211242189*!$*)$&)$@)!(@$o";
        char expectedLetter = 'o';
        // when
        char extractedLetter = HangmanUI.extractLetterFromInputString(inputString);
        // then
        Assertions.assertEquals(expectedLetter, extractedLetter);
    }
}
