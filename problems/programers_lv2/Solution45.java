package programers_lv2;

import java.util.Arrays;

public class Solution45 {
    public static int[] solution(String s) {

        int[] result = new int[2];
        while (!s.equals("1")) {
            result[0]++;

            int before = s.length();
            s = s.replace("0", "");
            result[1] += before - s.length();
            s = Integer.toBinaryString(s.length());
        }

        return result;
    }
}
