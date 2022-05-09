package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main4 {

    static int n;
    static int m;
    static int[] arr;

    static int answer = Integer.MAX_VALUE;

    static void dfs(int depth, int sum) {

        if (depth >= answer) return;
        if (sum > m) return;
        if (sum == m) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            dfs(depth + 1, sum + arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());

        dfs(0, 0);

        System.out.println(answer);
    }
}
