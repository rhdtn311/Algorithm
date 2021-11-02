package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11399version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(s[i])]++;
        }

        int sum = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 ) continue;
            for (int j = 0; j < arr[i]; j++) {
                sum += i;
                result += sum;
            }
        }

        System.out.println(result);
    }
}
