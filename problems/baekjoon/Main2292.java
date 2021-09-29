package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1, 1+6, 1+6+12, 1+6+12+18
        int i = 1;
        int count = 1;
        while (n > i) {
            i = i + (6*count);
            count++;
        }

        System.out.println(count);
    }
}
