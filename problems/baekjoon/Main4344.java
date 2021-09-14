package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += Integer.parseInt(s[j]);
            }

            double avg = (double)sum / m;
            int count = 0;
            for (int k = 1; k <= m; k++) {
                int score = Integer.parseInt(s[k]);
                if (score > avg) {
                    count++;
                }
            }

            System.out.println(String.format("%.3f", (double)count*100/m) + "%");
        }
    }
}
