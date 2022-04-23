package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase().replaceAll("[^A-Z]", "");
        String compareStr = new StringBuilder(str).reverse().toString();

        if (str.equals(compareStr)) System.out.println("YES");
        else System.out.println("NO");

    }
}
