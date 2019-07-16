package services;

import java.util.Comparator;

public interface TextService {
    String getWordsInLowerCase(String text);

    String findWord(String text, Comparator<String> comparator);
}
