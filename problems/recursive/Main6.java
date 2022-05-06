package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            dfs(n, i, 1, new StringBuilder());
        }
    }

    static void dfs(int n, int depth, int start, StringBuilder sb) {
        if (depth == 0) {
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= n; i++) {
            dfs(n, depth - 1, i + 1,sb.append(i));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
