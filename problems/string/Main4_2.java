package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {

            String input = br.readLine();

            System.out.println(reverse(input));
        }
    }

    static String reverse(String str) {

        char[] arr = str.toCharArray();

        StringBuilder sb = new StringBuilder();

        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            char temp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = temp;

            lt++;
            rt--;
        }

        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }
}
