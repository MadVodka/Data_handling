package services;

import comparators.LongestStringComparator;
import comparators.ShortestStringComparator;

import java.util.Comparator;
import java.util.List;

public class TextDemoService implements DemoService {
    private TextService textService = new TextServiceImpl();
    private static final String text = "Ребе, Ви случайно не \n" +
            "знаете, сколько тогда Иуда получил по нынешнему курсу?";

    @Override
    public void run() {
        System.out.println("------ Start of text demo (task 4) -----");
        showWordsFromText();
        showWordsByLength();
        showPhoneNumbers();
        showChangedTemplate();
    }

    private void showWordsFromText() {
        System.out.println("----- Words from text (task 4.1) -----");
        String words = textService.getWordsInLowerCase(text);
        System.out.println(words);
        System.out.println();
    }

    private void showWordsByLength() {
        System.out.println("------ Shortest and longest words (task 4.2) ------");
        Comparator<String> shortestStringComparator = new ShortestStringComparator();
        String shortestWord = textService.findWord(text, shortestStringComparator);
        System.out.printf("Shortest word is %s%n", shortestWord);
        Comparator<String> longestStringComparator = new LongestStringComparator();
        String longestWord = textService.findWord(text, longestStringComparator);
        System.out.printf("Longest word is %s%n", longestWord);
        System.out.println();
    }

    private void showPhoneNumbers() {
        System.out.println("------ Find Izhevsk phone numbers in text (task 4.3) ------");
        String text = "Дана строка, содержащая в себе, помимо прочего, номера телефонов. Необходимо удалить из этой строки префиксы локальных\n" +
                "номеров, соответствующих Ижевску. Например, из +7 (3412) 510-640 получить 517-647; 8 (3412) 4697-32 > 4997-12; +7 3412 " +
                "96-11-97 > 90-41-90";
        System.out.println("The text:\n" + text);
        List<String> phoneNumbers = textService.findPhoneNumbers(text);
        System.out.println("Phone numbers: " + phoneNumbers);
        System.out.println();
    }

    private void showChangedTemplate() {
        String templateMail = "Уважаемый, $userName, извещаем вас о том, что на вашем счете " +
                "$accountNumber скопилась сумма, превышающая стоимость $monthCount месяцев пользования " +
                "нашими услугами. Деньги продолжают поступать. Вероятно, вы неправильно настроили " +
                "автоплатеж. С уважением, $employeeName, $employeePost.";

        String userName = "$userName Vatokat2000";
        String accountNumber = "$accountNumber 44352/8734";
        String monthCount = "$monthCount 6";
        String employeeName = "$employeeName Сергиенко Николай";
        String employeePost = "$employeePost Старший менеджер по взаимодействию с клиентами";


        String filledTemplate = textService.changePlaceHolders(templateMail, userName, accountNumber,
                monthCount, employeeName, employeePost);
        System.out.println("------ Fill in template (task 4.4) ------");
        System.out.println("Template:");
        System.out.println(templateMail+"\n");
        System.out.println("Filled template:");
        System.out.println(filledTemplate+"\n");
    }
}
