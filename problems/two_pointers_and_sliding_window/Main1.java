package two_pointers_and_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        StringBuilder answer = new StringBuilder();

        int left = 0;
        int right = 0;
        while (left < n || right < m) {

            if (left >= n || Integer.parseInt(input1[left]) > Integer.parseInt(input2[right])) {
                answer.append(input2[right]).append(" ");
                right++;
                continue;
            }

            if (right >= m || Integer.parseInt(input1[left]) <= Integer.parseInt(input2[right])) {
                answer.append(input1[left]).append(" ");
                left++;
            }
        }

        System.out.println(answer);
    }
}
