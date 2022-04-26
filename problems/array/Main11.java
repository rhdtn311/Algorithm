package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[i][j] == arr[k][j]) temp[k]=1;
                }
            }

            int count = 0;
            for (int k = 0; k < n; k++) {
                if (temp[k]==1) count++;
            }

            if (max < count) {
                max = count;
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}