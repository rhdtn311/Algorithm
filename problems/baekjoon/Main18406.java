package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main18406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2);

        int leftValue = 0;
        int rightValue = 0;
        for (int i = 0; i < left.length(); i++) {
            leftValue += Character.getNumericValue(left.charAt(i));
            rightValue += Character.getNumericValue(right.charAt(i));
        }

        if (leftValue == rightValue) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
