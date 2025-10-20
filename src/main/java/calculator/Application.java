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

        int sum = 0;
        StringBuffer numberBuffer = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (isDelimiter(currentChar)) {
                sum += toInt(numberBuffer.toString());
                numberBuffer.setLength(0);
            } else {
                numberBuffer.append(currentChar);
            }
        }

        sum += toInt(numberBuffer.toString());

        return sum;
    }

    private static boolean isDelimiter(char c) {
        return c == ',' || c == ':';
    }

    private static int toInt(String s) {
        return Integer.parseInt(s.trim());
    }
}
