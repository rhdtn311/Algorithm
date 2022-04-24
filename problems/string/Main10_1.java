package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        char[] arr = input[0].toCharArray();
        char x = input[1].charAt(0);

        int[] temp = new int[arr.length];
        int p = 101;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) p = 0;

            temp[i] = p++;
        }

        p = 101;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) p = 0;

            temp[i] = Math.min(temp[i], p++);
        }

        StringBuilder answer = new StringBuilder();
        for (int c : temp) {
            answer.append(c).append(" ");
        }

        System.out.println(answer);
    }
}
