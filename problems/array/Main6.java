package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(new StringBuilder(arr[i]).reverse().toString());

            if (isPrime(num)) answer.append(num).append(" ");
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
