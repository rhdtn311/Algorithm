package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        arr[1] = 1;

        StringBuilder answer = new StringBuilder();
        answer.append(1).append(" ");
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
            answer.append(arr[i]).append(" ");
        }

        System.out.println(answer);
    }
}
