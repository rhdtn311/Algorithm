package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] s = br.readLine().split(" ");

            double first = Double.parseDouble(s[0]);
            double second = Double.parseDouble(s[1]);

            if (first == second) break;

            if (first / second >= 1) {
                if (first % second == 0) {
                    System.out.println("multiple");
                    continue;
                }
            } else {
                if (second % first == 0) {
                    System.out.println("factor");
                    continue;
                }
            }

            System.out.println("neither");
        }
    }
}
