package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        // 커스텀 구분자 처리를 위한 정규식 패턴
        Matcher m = Pattern.compile("//(.+)\\\\n(.*)").matcher(text);
        String[] stringNumbers;

        if (m.find()) {
            String customDelimiter = m.group(1); // 커스텀 구분자 추출
            String numbersText = m.group(2); // 숫자 부분 추출
            // 기본 구분자와 커스텀 구분자를 모두 사용하여 분리
            stringNumbers = numbersText.split(",|:" + "|" + Pattern.quote(customDelimiter));
        } else {
            // 커스텀 구분자가 없을 경우 기존 로직 수행
            stringNumbers = text.split("[,:]");
        }

        List<Integer> numbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String sNum : stringNumbers) {
            if (!sNum.trim().isEmpty()) {
                int number = Integer.parseInt(sNum.trim());
                if (number < 0) {
                    negativeNumbers.add(number);
                }
                numbers.add(number);
            }
        }

        if (!negativeNumbers.isEmpty()) {
            String negativeStr = negativeNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + negativeStr);
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
