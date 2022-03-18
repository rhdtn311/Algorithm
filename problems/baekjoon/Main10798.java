package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = new String[5];
        int length = 0;
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            arr[i] = input;
            length = Math.max(length, input.length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length()) {
                    sb.append(arr[j].charAt(i));
                }
            }
        }

        System.out.println(sb);



    }
}
