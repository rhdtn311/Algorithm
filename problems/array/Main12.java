package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                boolean isMentor = true;
                for (int k = 0; k < m; k++) {
                    int gi = 0, gj = 0;
                    for (int l = 0; l < n; l++) {
                        if (arr[k][l] == i + 1) gi = l;
                        if (arr[k][l] == j + 1) gj = l;
                    }

                    if (gi > gj) {
                        isMentor = false;
                        break;
                    }
                }
                if (isMentor) count++;
            }
        }

        System.out.println(count);

    }
}
