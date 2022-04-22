package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {

            String input = br.readLine();
            StringBuilder sb = new StringBuilder();

            for (int i = input.length() - 1; i >= 0; i--) {
                sb.append(input.charAt(i));
            }

            System.out.println(sb);
        }
    }
}
