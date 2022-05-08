package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    static int C, N;
    static int answer = 0;
    static int[] arr;

    static void dfs(int depth, int sum) {
        if (sum > C) return;
        if (depth == N) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] CN = br.readLine().split(" ");
        C = Integer.parseInt(CN[0]);
        N = Integer.parseInt(CN[1]);

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
        System.out.println(answer);
    }


}
