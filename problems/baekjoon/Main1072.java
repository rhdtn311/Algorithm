package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        long origin = (long) ((double) y * 100 / x);

        long answer = 0;
        long min = 0;
        long max = 2000000000;
        while (min <= max) {
            long mid = (min + max) / 2;

            long plusX = x + mid;
            long plusY = y + mid;
            if ((long) ((double) plusY * 100 / plusX) != origin) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(answer == 0 ? -1 : answer);
    }
}