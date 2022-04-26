package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) + 2;

        int[][] arr = new int[n][n];
        for (int i = 1; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j < n - 1; j++) {
                arr[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (arr[i][j] > arr[i - 1][j] && arr[i][j] > arr[i][j - 1] && arr[i][j] > arr[i + 1][j] && arr[i][j] > arr[i][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
