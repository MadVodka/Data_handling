package services;

import comparators.LongestStringComparator;
import comparators.ShortestStringComparator;

import java.util.Comparator;

public class TextDemoService implements DemoService {
    private TextService textService = new TextServiceImpl();
    private static final String text = "Ребе, Ви случайно не \n" +
            "знаете, сколько тогда Иуда получил по нынешнему курсу?";

    @Override
    public void run() {
        System.out.println("------ Start of text demo (task 4) -----");
        showWordsFromText();
        showWords();
    }

    private void showWordsFromText() {
        System.out.println("----- Words from text (task 4.1) -----");
        String words = textService.getWordsInLowerCase(text);
        System.out.println(words);
        System.out.println();
    }

    private void showWords() {
        System.out.println("------ Shortest and longest words (task 4.2) ------");
        Comparator<String> shortestStringComparator = new ShortestStringComparator();
        String shortestWord = textService.findWord(text, shortestStringComparator);
        System.out.printf("Shortest word is %s%n",shortestWord);
        Comparator<String> longestStringComparator = new LongestStringComparator();
        String longestWord = textService.findWord(text, longestStringComparator);
        System.out.printf("Longest word is %s%n",longestWord);
        System.out.println();
    }
}
