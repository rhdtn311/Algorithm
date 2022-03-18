package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] result = new char[]{'E', 'A', 'B', 'C', 'D'};
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");

            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(input[j]) == 0) {
                    count++;
                }
            }

            System.out.println(result[count]);
        }
    }
}
