package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int prev = 0;
        for (int i = 0; i < k; i++) {
            prev += arr[i];
        }

        int left = 0;
        int right = k;
        int max = prev;
        while (right < n) {
            prev = prev - arr[left++] + arr[right++];
            max = Math.max(prev, max);
        }

        System.out.println(max);

    }
}
