package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer = "";
        char[] arr = input.toCharArray();

        for (char c : arr) {
            if (answer.indexOf(c) == -1) {
                answer += c;
            }
        }

        System.out.println(answer);
    }
}
