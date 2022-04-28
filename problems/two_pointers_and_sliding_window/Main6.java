package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main6 {
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
        int right;
        int answer = 0;
        for (right = 0; right < n; right++) {
            if (arr[right] == 1) {
                count++;
            } else {
                if (k > 0) {
                    k--;
                    count++;
                } else {
                    while (arr[left] == 1) {
                        left++;
                        count--;
                    }
                    left++;
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
