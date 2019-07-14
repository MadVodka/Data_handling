package services;

public class NumberServiceImpl implements NumberService {
    @Override
    public double findMinNumber(double number1, double number2, double number3) {
        double min = Math.min(number1, number2);
        min = Math.min(min, number3);
        return min;
    }

    @Override
    public double findMaxNumber(double number1, double number2, double number3) {
        double max = Math.max(number1, number2);
        max = Math.max(max, number3);
        return max;
    }

    /**
     *
     * @param numbers for instance: 23, 56.097, 0.49
     * @return 0 if true, 1 if false and -1 if incoming params follow the pattern
     */
    @Override
    public int isThirdNumberSumOfFirstTwo(String numbers) {
        String pattern = "(([0]{1}|([1-9]{1}(\\d)*))([.]?(\\d+))?(, )?){3}";
        if (numbers.matches(pattern)) {
            String[] strings = numbers.split(", ", 3);
            double first = Double.valueOf(strings[0]);
            double second = Double.valueOf(strings[1]);
            double third = Double.valueOf(strings[2]);
            double sum = first + second;
            if (Double.compare(sum, third) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        return -1;
    }
}
