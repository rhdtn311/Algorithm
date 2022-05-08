package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {

    static int n;

    static int[] arr;
    static int avg;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        if (Arrays.stream(arr).sum() % 2 == 1) {
            System.out.println("NO");
            System.exit(0);
        }

        avg = Arrays.stream(arr).sum() / 2;

        dfs(0, 0);

        System.out.println("NO");
    }

    static void dfs(int sum, int start) {

        if (sum == avg) {
            System.out.println("YES");
            System.exit(0);
        }

        if (sum > avg) {
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(sum + arr[i], i + 1);
                visited[i] = false;
            }
        }

    }
}
