package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11054 {

    static int[] arr;
    static int[] dpUp;
    static int[] dpDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dpUp = new int[n];
        dpDown = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            dpUp[i] = 1;
            dpDown[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dpUp[i] <= dpUp[j]) {
                    dpUp[i] = dpUp[j] + 1;
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; i < j; j--) {
                if (arr[i] > arr[j] && dpDown[i] <= dpDown[j]) {
                    dpDown[i] = dpDown[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dpUp[i] + dpDown[i], max);
        }

        System.out.println(max-1);
    }
}
