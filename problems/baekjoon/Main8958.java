package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int sum = 0;
            int score = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    score++;
                } else {
                    score = 0;
                }
                sum+=score;
            }
            System.out.println(sum);
        }
    }
}
