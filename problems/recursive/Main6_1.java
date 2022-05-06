package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6_1 {

    static int n; // n = 3이면 , {1,2,3}
    static int[] arr;

    public static void main(String[] args) throws IOException {

        n = 3;
        arr = new int[n + 1];  // arr = {0, 0, 0, 1}

        dfs(1);
    }

    static void dfs(int depth) {
        if (depth == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        arr[depth] = 1;
        dfs(depth + 1);
        arr[depth] = 0;
        dfs(depth + 1);
    }
}