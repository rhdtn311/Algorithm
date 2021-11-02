package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = 0;

        boolean plus = true;
        StringBuilder sb = new StringBuilder("0");
        for (char c : s.toCharArray()) {
            if (c == '+') {
                if (plus) {
                    result += Integer.parseInt(sb.toString());
                } else {
                    result -= Integer.parseInt(sb.toString());
                }
                sb = new StringBuilder("0");
            } else if (c == '-') {
                if (plus) {
                    result += Integer.parseInt(sb.toString());
                    plus = false;
                } else {
                    result -= Integer.parseInt(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        if (plus) {
            result += Integer.parseInt(sb.toString());
        } else {
            result -= Integer.parseInt(sb.toString());
        }

        System.out.println(result);
    }
}
