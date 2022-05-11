package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main8 {

    static int N, F;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static boolean flag = false;
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NF = br.readLine().split(" ");
        N = Integer.parseInt(NF[0]);
        F = Integer.parseInt(NF[1]);

        temp = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        dfs(0);

        System.out.println(answer);

    }

    static void dfs(int depth) {
        if (flag) return;

        if (depth == N) {
            temp = new int[N];
            for (int i = 0; i < N; i++) {
                answer += (arr[i] + " ");
                temp[i] = arr[i];
            }

            int m = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - m; j++) {
                    temp[j] = temp[j] + temp[j + 1];
                }
                m++;
            }

            if (temp[0] == F) {
                flag = true;
                return;
            } else {
                answer = "";
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i - 1] = false;
            }
        }
    }
}
