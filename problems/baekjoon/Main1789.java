package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long max = 0;
        long value = 1;
        while (true) {
            S -= value;
            max = value;

            if (S <= max) {
                System.out.println(value);
                break;
            }

            value++;
        }
    }
}
