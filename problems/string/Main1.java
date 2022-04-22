package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String alpha = br.readLine();

        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.toLowerCase(c) == alpha.charAt(0) || Character.toUpperCase(c) == alpha.charAt(0)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
