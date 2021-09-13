package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        int original = Integer.parseInt(s.toString());

        int count = 0;
        while(true) {
            count++;
            if (s.length() == 1) {
                s.insert(0,0);
            }
            int i1 = Character.getNumericValue(s.charAt(0));
            int i2 = Character.getNumericValue(s.charAt(1));
            int sum = i1 + i2;
            s = new StringBuilder(String.valueOf(i2) + String.valueOf(sum).charAt(String.valueOf(sum).length()-1) );
            if (original == Integer.parseInt(s.toString())) {
                break;
            }
        }

        System.out.println(count);

    }
}
