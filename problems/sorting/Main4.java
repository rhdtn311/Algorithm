package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sn = br.readLine().split(" ");
        int s = Integer.parseInt(sn[0]);
        int n = Integer.parseInt(sn[1]);
        String[] input = br.readLine().split(" ");

        int[] cache = new int[s];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(input[i]);
            int idx = -1;
            for (int j = 0; j < s; j++) if (cache[j] == val) idx = j;

            if (idx == -1) {
                for (int j = s - 1; j > 0; j--) {
                    cache[j] = cache[j - 1];
                }
            } else {
                for (int j = idx; j > 0; j--) {
                    cache[j] = cache[j - 1];
                }
            }
            cache[0] = val;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            sb.append(cache[i]).append(" ");
        }

        System.out.println(sb);

    }
}
