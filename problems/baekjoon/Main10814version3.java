package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10814version3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = s[0];
            arr[i][1] = s[1];
        }

        Arrays.sort(arr, (str1, str2) -> {
            return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <n; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
