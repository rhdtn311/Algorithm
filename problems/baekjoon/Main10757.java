package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder s1 = new StringBuilder(s[0]);
        StringBuilder s2 = new StringBuilder(s[1]);

        int maxLength = Math.max(s1.length(), s2.length());
        int shortLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < maxLength - shortLength + 1; i++) {
            if (s1.length() > s2.length()) {
                s2.insert(0,0);
            }
            if (s1.length() < s2.length()) {
                s1.insert(0,0);
            }
        }
        s1.insert(0,0);
        s2.insert(0,0);

        int plus = 0;
        int a = 0;
        StringBuilder result = new StringBuilder();
        for (int i = s1.length() - 1 ; i >= 0; i--) {
            int n1 = Character.getNumericValue(s1.charAt(i));
            int n2 = Character.getNumericValue(s2.charAt(i));

            plus = n1 + n2 + a;
            if (plus > 9) {
                a = 1;
            } else {
                a = 0;
            }
            result.insert(0,plus % 10);
        }
        if (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        System.out.println(result);
    }
}
