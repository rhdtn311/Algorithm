package programers_lv2;

import java.util.Arrays;

public class Solution31 {
    public static int solution(int[] citations) {
        int[] arr = new int[10001];

        int maxValue = 0;
        for (int i = 0; i < citations.length; i++) {
            arr[citations[i]]++;
            maxValue = Math.max(maxValue, citations[i]);
        }

        int min = 0;
        int max = maxValue + 1;
        while (min < max) {
            int mid = (min + max) / 2;

            int high = 0;
            for (int i = mid; i <= maxValue; i++) {
                high += arr[i];
            }

            if (mid <= high) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min-1;
    }
}
