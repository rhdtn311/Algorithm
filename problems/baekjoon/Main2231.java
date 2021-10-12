package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = n; i > 0; i--) {
            if (n == make(i)) {
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static int make(int n) {
        int sum = n;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
