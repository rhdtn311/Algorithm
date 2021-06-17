import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class etc_02 {
    // 구름 약수구하기 (https://level.goorm.io/exam/43255/%EC%95%BD%EC%88%98-%EA%B5%AC%ED%95%98%EA%B8%B0/quiz/1)
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);

        ArrayList<Integer> result = new ArrayList<>();

        IntStream.rangeClosed(1,number).forEach(i -> {
            if (number % i == 0) {
                result.add(i);
            }
        });

        result.forEach( i -> {
            System.out.print(i+ " ");
        });
    }
}
