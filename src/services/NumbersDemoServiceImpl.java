package services;

import entity.Circle;

public class NumbersDemoServiceImpl implements DemoService {
    private NumberService numberService = new NumberServiceImpl();

    @Override
    public void run() {
        System.out.println("------ Numbers demo (task 2) start------");

        showSquareCircle();

        showMinAndMaxNumbers();

        String numbers1 = "0.23, 1, 1.23";
        String numbers2 = "10, 59, 100.67";
        showSum(numbers1);
        showSum(numbers2);

        System.out.println("------ Numbers demo (task 2) end ------");
    }

    private void showSquareCircle() {
        CircleService circleService = new CircleServiceImpl();
        Circle circle = new Circle(104.54674);
        String square = circleService.square(circle).toPlainString();
        System.out.printf("Square of circle with radius %f is %s%n", circle.getRadius(), square);
    }

    private void showMinAndMaxNumbers() {
        double num1 = 56;
        double num2 = 146;
        double num3 = -89;

        double min = numberService.findMinNumber(num1, num2, num3);
        double max = numberService.findMaxNumber(num1, num2, num3);

        System.out.printf("Min is %.2f and max is %.2f among numbers: %.2f, %.2f, %.2f%n",
                min, max, num1, num2, num3);
    }

    private void showSum(String numbers) {
        int result = numberService.isThirdNumberSumOfFirstTwo(numbers);
        String answer;
        if (result == 0) {
            answer = "yes";
        } else if (result == 1) {
            answer = "no";
        } else {
            System.out.printf("Written numbers %s don't follow the pattern%n", numbers);
            return;
        }
        System.out.printf("Is third number a sum of first two numbers in a string of %s: %s%n",
                numbers, answer);
    }
}
