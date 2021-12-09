package programers_lv1;

import java.util.Arrays;

public class Solution23version2 {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] =  Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            if (result[i].length() < n) {
                int length = result[i].length();
                for (int j = 0; j < n - length; j++) {
                    result[i] = '0' + result[i];
                }
            }

            result[i] = result[i].replaceAll("0", " ").replaceAll("1", "#");
        }

        return result;
    }
}
