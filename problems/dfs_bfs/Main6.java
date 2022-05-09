package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {

    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static int[] temp;

    static void permutation(int depth) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        String[] input = br.readLine().split(" ");

        visited = new boolean[n];
        temp = new int[n];
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        permutation(0);
    }

}
