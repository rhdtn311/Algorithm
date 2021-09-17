package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Character.getNumericValue(s.charAt(i));
            sum += num;
        }

        System.out.println(sum);

    }
}