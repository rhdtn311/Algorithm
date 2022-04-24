package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int num = 0;
        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57) {
                num = num * 10 + Character.getNumericValue(c);
            }
        }

        System.out.println(num);
    }
}
