package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int index = 1;
        int num = 666;
        while(index <= n) {
            if (String.valueOf(num).contains("666")) {
                arr[index] = num;
                index++;
            }
            num++;
        }
        System.out.println(arr[n]);
    }
}
