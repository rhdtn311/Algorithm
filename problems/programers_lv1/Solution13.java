package programers_lv1;

import java.util.Arrays;

public class Solution13 {
    public int solution(int n, int[] lost, int[] reserve) {

        int result = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    result++;
                    reserve[j] = -1;
                    lost[i] = -1;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) {
                continue;
            }
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) {
                    continue;
                }
                if (lost[i] - 1 == reserve[j]) {
                    reserve[j] = -1;
                    result++;
                    break;
                }
                if (lost[i] + 1 == reserve[j]) {
                    reserve[j] = -1;
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}
