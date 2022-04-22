package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String answer = "";

        String[] arr = input.split(" ");
        for (String str : arr) {
            if (answer.length() < str.length()) answer = str;
        }

        System.out.println(answer);
    }
}
