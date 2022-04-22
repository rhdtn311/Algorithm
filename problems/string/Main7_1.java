package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String reverse = new StringBuilder(str).reverse().toString();

        String answer = "NO";
        if (str.equalsIgnoreCase(reverse)) answer = "YES";

        System.out.println(answer);

    }
}
