package services;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
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

    @Override
    public String[] findPhoneNumbers(String text) {
        String wholePhoneNumberPattern = "((([+]7)|[7]|[8])?)[ ]?[(]?3412[)]?[ ]" +
                "([2-9](-| )?\\d(-| )?\\d(-| )?\\d(-| )?\\d(-| )?\\d)";
        Pattern wholePhoneNumber = Pattern.compile(wholePhoneNumberPattern);
        Pattern cityPhonePattern = Pattern.compile("([2-9](-| )?\\d(-| )?\\d(-| )?\\d(-| )?\\d(-| )?\\d)$");
        Matcher matcher = wholePhoneNumber.matcher(text);
        while (matcher.find()) {
            String phone = text.substring(matcher.start(), matcher.end());
            System.out.println(phone);
            Matcher matcher1 = cityPhonePattern.matcher(phone);
            while (matcher1.find()) {
                String city = phone.substring(matcher1.start());
                System.out.println(city);
            }
        }
        return null;
    }
}
