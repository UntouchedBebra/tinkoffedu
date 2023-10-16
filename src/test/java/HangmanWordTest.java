import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projectone.HangmanWord;

public class HangmanWordTest {
    HangmanWord hangmanWord;

    @BeforeEach void testHangmanWordInitialization() {
        // given
        hangmanWord = new HangmanWord("son");
    }

    @DisplayName("Угадывание буквы") @Test void testCorrectWordGuessAttempt() {
        // when
        boolean letterIsGuessed = hangmanWord.guessLetter('s');
        // then
        Assertions.assertTrue(letterIsGuessed);
    }

    @DisplayName("Неугадывание буквы") @Test void testIncorrectWordGuessAttempt() {
        // when
        boolean letterIsGuessed = hangmanWord.guessLetter('q');
        // then
        Assertions.assertFalse(letterIsGuessed);
    }

    @DisplayName("Проверка на завершение составления слова") @Test void testWordIsComposed() {
        // when
        hangmanWord.guessLetter('s');
        hangmanWord.guessLetter('o');
        hangmanWord.guessLetter('n');

        Assertions.assertFalse(hangmanWord.wordNotComposed());
    }

    @DisplayName("Проверка на незавершенность составления слова") @Test void testWordNotComposed() {
        // when
        hangmanWord.guessLetter('s');
        // then
        Assertions.assertTrue(hangmanWord.wordNotComposed());
    }

    @DisplayName("Получение текущего состояния угадываемого слова") @Test void testGetPartiallyGuessedWordStatement() {
        // when
        hangmanWord.guessLetter('s');
        String currentWordStatement = hangmanWord.getCurrentWordStatement();
        // then
        Assertions.assertEquals("s**", currentWordStatement);
    }

    @DisplayName("Получение текущего состояния угадываемого слова") @Test void testGetFullyGuessedWordStatement() {
        // when
        hangmanWord.guessLetter('s');
        hangmanWord.guessLetter('o');
        hangmanWord.guessLetter('n');
        String currentWordStatement = hangmanWord.getCurrentWordStatement();
        // then
        Assertions.assertEquals("son", currentWordStatement);
    }
}
