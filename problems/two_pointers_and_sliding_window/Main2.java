package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        StringBuilder answer = new StringBuilder();

        int ap = 0;
        int bp = 0;
        while (ap < n && bp < m) {
            if (a[ap] == b[bp]) {
                answer.append(a[ap]).append(" ");
                ap++; bp++;
            } else if (a[ap] > b[bp]) bp++;
            else ap++;
        }

        System.out.println(answer);
    }
}
