package programers_lv2;

import java.util.Arrays;

public class Solution61 {

    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];

        while (true) {
            boolean check = true;

            for (int i = 0; i < arr.length; i++) {
                if (max % arr[i] != 0) {
                    check = false;
                    break;
                }
            }

            if (!check) {
                max += arr[arr.length - 1];
            } else {
                break;
            }

        }

        return max;
    }
}
