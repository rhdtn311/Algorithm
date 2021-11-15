package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10816version3 {

    static int[] arr = new int[20000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(s[i]);

            arr[num + 10000000]++;
        }

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        String[] find = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            sb.append(arr[Integer.parseInt(find[i]) + 10000000]).append(' ');
        }

        System.out.println(sb);
    }
}
