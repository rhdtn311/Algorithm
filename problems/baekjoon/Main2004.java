package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);

        int two1 = checkTwo(n);
        int five1 = checkFive(n);

        int two2 = checkTwo(n - r) + checkTwo(r);
        int five2 = checkFive(n - r) + checkFive(r);

        int two = two1 - two2;
        int five = five1 - five2;
        if (two <= 0 || five <= 0) {
            System.out.println(0);
        } else {
            System.out.println(Math.min(five, two));
        }
    }

    static int checkFive(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }

    static int checkTwo(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 2;
            n /= 2;
        }

        return count;
    }
}
