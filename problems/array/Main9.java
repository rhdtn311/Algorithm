package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9 {
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

        int max = 0;


        int sum3 = 0;
        int sum4 = 0;
        for (int i = 0; i < n; i++) {
            int sum1 = 0;
            int sum2 = 0;

            sum3 += arr[i][i];
            sum4 += arr[i][n - 1 - i];
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }

            max = Math.max(Math.max(max, sum1), sum2);
            max = Math.max(Math.max(max, sum3), sum4);
        }

        System.out.println(max);
    }
}
