package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int answer = 0;
        int sum = 0;

        for (right = 1; right < n; right++) {
            sum += right;

            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -= left++;

                if (sum == n) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
