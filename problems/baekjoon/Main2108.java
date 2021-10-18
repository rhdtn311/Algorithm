package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] count = new int[8001];
        int mostBig = Integer.MIN_VALUE;
        int mostSmall = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            count[arr[i]+4000]++;
            if (mostBig < arr[i]) {
                mostBig = arr[i];
            }
            if (mostSmall > arr[i]) {
                mostSmall = arr[i];
            }
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        sb.append(Math.round((double)sum/n)).append("\n");
        sb.append(arr[n/2]).append("\n");

        int max = 0;
        int cnt = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i ++) {
//            System.out.println("count[arr[i]+4000] : " + count[arr[i]+4000] + "   arr[i] : " + arr[i] + "   count : " + cnt);
            if (i > 0) {
                if (arr[i] == arr[i-1]) {
                    continue;
                }
            }
            if (max < count[arr[i]+4000]) {
                max = count[arr[i]+4000];
                maxValue = arr[i];
                cnt = 1;
            } else if (max == count[arr[i]+4000]) {
                cnt ++;
                if (cnt == 2) {
                    maxValue = arr[i];
                }
            }
        }
        sb.append(maxValue).append("\n");
        sb.append(mostBig - mostSmall);
        System.out.println(sb);
    }
}
