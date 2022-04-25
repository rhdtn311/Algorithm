package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        StringBuilder sb = new StringBuilder().append(arr[0]).append(" ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
