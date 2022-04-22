package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String answer = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) == i) answer += input.charAt(i);
        }

        System.out.println(answer);
    }
}
