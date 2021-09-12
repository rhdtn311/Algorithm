package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        if (s % 4 == 0 && s % 100 != 0) {
            System.out.println(1);
            System.exit(0);
        }
        if (s % 4 == 0 && s % 400 == 0) {
            System.out.println(1);
            System.exit(0);
        }
        System.out.println(0);
    }
}
