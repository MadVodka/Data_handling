package services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class TextServiceImpl implements TextService {
    @Override
    public String getWordsInLowerCase(String text) {
        Pattern pattern = Pattern.compile("[^а-яА-яa-zA-Z]+");
        String[] words = pattern.split(text);

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word.toLowerCase()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String findWord(String text, Comparator<String> comparator) {
        Pattern pattern = Pattern.compile("[^а-яА-яa-zA-Z]+");
        String[] words = pattern.split(text);
        Arrays.sort(words, comparator);
        if (words.length>0) {
            return words[0];
        }
        return null;
    }
}
