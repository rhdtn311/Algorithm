package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 0;
        int answer = 0;
        int count = 0;
        while (true) {
            if (answer > n) {
                answer -= left++;
            } else if (right >= n) {
                break;
            } else {
                answer += right++;
            }

            if (answer == n) count++;
        }

        System.out.println(count);
    }
}
