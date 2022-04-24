package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) count++;

            int j = i;
            while (j <= n) {
                arr[j] = 1;
                j += i;
            }
        }

        System.out.println(count);
    }
}
