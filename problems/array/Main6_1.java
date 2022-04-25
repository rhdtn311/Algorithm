package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main6_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);

            int temp = 0;
            while (num > 0) {
                temp = temp * 10 + (num % 10);

                num /= 10;
            }

            if (isPrime(temp)) answer.append(temp).append(" ");
        }

        System.out.println(answer);
    }

    static boolean isPrime(int n) {
        if (n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
