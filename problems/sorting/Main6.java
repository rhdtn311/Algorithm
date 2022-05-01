package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] copy_arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy_arr);

        String answer = "";
        for (int i = 0; i < n; i++) {
            if (arr[i] != copy_arr[i]) answer += (i + 1) + " ";
        }

        System.out.println(answer);

    }
}
