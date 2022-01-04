package programers_lv2;

import java.util.Arrays;

public class Solution37 {
    public static int[] solution(int n) {

        if (n == 1) {
            return new int[]{1};
        }
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] inside = new int[i + 1];
            arr[i] = inside;
        }

        int value = 1;
        int i = 0;
        int j = 0;

        boolean under = true;
        boolean right = false;
        while (true) {

            if (arr[i][j] != 0) {
                break;
            }

            arr[i][j] = value;

            if (under) {
                i++;
                value++;
                if (i >= n || arr[i][j] != 0) {
                    under = false;
                    right = true;
                    i--;
                    j++;
                }
                continue;
            }

            if (right) {
                j++;
                value++;
                if (j >= n || arr[i][j] != 0) {
                    right = false;
                    j -= 2;
                    i--;
                }
                continue;
            }

            i--;
            j--;
            value++;
            if (i <= 0 || arr[i][j] != 0) {
                under = true;
                i += 2;
                j++;
            }
        }

        int index = 0;
        for (int k = 1; k <= n; k++) {
            index += k;
        }

        int idx = 0;
        int[] result = new int[index];
        for (int[] a1 : arr) {
            for (int a : a1) {
                result[idx++] = a;
            }
        }
        return result;
    }
}
