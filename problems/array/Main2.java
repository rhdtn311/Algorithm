package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int answer = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                answer++;
                max = arr[i];
            }
        }

        System.out.println(answer);
    }
}
