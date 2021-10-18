package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num+1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < 2000001; i++) {
            if (arr[i]==0) continue;
            else {
                count++;
                sb.append(i-1000000).append("\n");
            }
            if (count == n) {
                break;
            }
        }
        System.out.println(sb);
    }
}
