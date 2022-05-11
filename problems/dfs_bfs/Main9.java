package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9 {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        combination(0, 1, new int[m]);
    }

    static void combination(int depth, int start, int[] temp) {

        if (depth == m) {
            for (int v : temp) {
                System.out.print(v + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            temp[depth] = i;
            combination(depth + 1, i + 1, temp);
        }
    }
}
