package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        for (right = 0; right < n; right++) {
            sum += arr[right];

            if (sum == m) {
                count++;
            }

            while (sum >= m) {
                sum -= arr[left++];
                if (sum == m) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
