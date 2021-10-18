package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
