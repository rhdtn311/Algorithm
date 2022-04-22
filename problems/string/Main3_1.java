package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer = "";
        while (input.indexOf(" ") != -1) {
            int index = input.indexOf(" ");
            String word = input.substring(0, index);

            if (answer.length() < word.length()) {
                answer = word;
            }

            input = input.substring(index + 1);
        }

        if (answer.length() < input.length()) {
            answer = input;
        }

        System.out.println(answer);
    }
}
