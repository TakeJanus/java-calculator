package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = add(input);

        System.out.println("결과 : " + result);
    }

    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] stringNumbers = text.split("[,:]");

        int sum = 0;
        for (String number : stringNumbers) {
            sum += Integer.parseInt(number.trim());
        }

        return sum;
    }

}
