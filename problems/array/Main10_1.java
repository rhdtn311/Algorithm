package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean isPeak = true;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (arr[i][j] <= arr[nx][ny]) {
                            isPeak = false;
                        }
                    }
                }

                if (isPeak) count++;
            }
        }

        System.out.println(count);
    }
}
