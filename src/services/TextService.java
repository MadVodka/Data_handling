package services;

import java.util.Comparator;
import java.util.List;

public interface TextService {
    String getWordsInLowerCase(String text);

    String findWord(String text, Comparator<String> comparator);

    List<String> findPhoneNumbers(String text);
}
