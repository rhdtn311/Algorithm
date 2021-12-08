package programers_lv1;

import java.util.Arrays;

public class Solution18 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int count = 0;
        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget >= 0) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
