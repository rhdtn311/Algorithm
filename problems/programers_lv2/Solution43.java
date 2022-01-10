package programers_lv2;

import java.util.Arrays;

public class Solution43 {

    public String solution(String s) {

        String[] split = s.split(" ");

        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        return arr[0] + " " + arr[arr.length - 1];
    }
}