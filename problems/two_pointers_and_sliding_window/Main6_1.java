package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6_1 {
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

        int count = 0;
        int left = 0;
        int right = 0;
        int answer = 0;
        while (true) {
            if (right >= n) break;

            if (arr[right] == 0) {
                if (k <= 0) {
                    if (arr[left] == 0) {
                        k++;
                    }
                    left++;
                    count--;
                } else {
                    k--;
                    right++;
                    count++;
                }
            } else {
                count++;
                right++;
            }

            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
