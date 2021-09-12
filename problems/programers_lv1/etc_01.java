package programers_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class etc_01 {
    // 구름 소수 판별 (https://level.goorm.io/exam/43238/%EC%86%8C%EC%88%98-%ED%8C%90%EB%B3%84/quiz/1)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);
        String answer = "True";

        if (number == 1 ) {
            System.out.println(false);
        } else if (number == 2) {
            System.out.println(true);
        } else {
            IntStream intStream = IntStream.range(2, number);

            for (int i : intStream.toArray()) {
                if (number % i == 0) {
                    answer = "False";
                    break;
                }
            }

        }
        System.out.println(answer);
    }
}
