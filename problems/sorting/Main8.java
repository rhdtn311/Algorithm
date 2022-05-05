package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int answer = 0;
        int min = 0;
        int max = n - 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (m < arr[mid]) {
                max = mid - 1;
            } else if (m == arr[mid]) {
                answer = mid;
                break;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(answer + 1);
    }
}
