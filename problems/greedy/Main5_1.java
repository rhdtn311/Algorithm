package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5_1 {

    static int[] unf;

    static int Find(int v) {
        if (unf[v] == v) return unf[v];
        return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        unf = new int[n+1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            Union(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        String[] result = br.readLine().split(" ");
        int fa = Find(Integer.parseInt(result[0]));
        int fb = Find(Integer.parseInt(result[1]));

        System.out.println(fa == fb ? "YES" : "NO");
    }
}
