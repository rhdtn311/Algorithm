package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        while (true) {
            int sum = 0;
            for (int i = index; i < index + K; i++) {
                sum += arr[i];
            }

            max = Math.max(max, sum);
            index++;

            if (index + K > N) {
                break;
            }
        }

        System.out.println(max);
    }
}
