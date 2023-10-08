package project1;
public class HangmanApp {
    private final Dictionary dictionary;
    private final HangmanWord hangmanWord;

    public HangmanApp() {
        dictionary = new Dictionary(HangmanUI.extractWordsFromInputString(
            HangmanUI.getInputString("Введите слова в строку через пробел",
            "Строка пуста | Не содержит латинских букв. Повторите ввод.")));
        hangmanWord = new HangmanWord(dictionary.getRandomWord());
    }


}
