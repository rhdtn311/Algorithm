package programers_lv2;

import javax.swing.plaf.basic.BasicComboPopup;
import java.util.Arrays;

public class Solution59 {

    static int max = 0;
    static int[] result = new int[11];

    public int[] solution(int n, int[] info) {

        check(n, 0, new boolean[11], new int[11], info);

        return max == 0 ? new int[] {-1} : result;
    }

    public void check(int n, int sum, boolean[] visited, int[] arrows, int[] info) {

        if (n == 0) {
            int lion = 0;
            int apeach = 0;
            for (int i = 0; i < 11; i++) {
                if (arrows[i] > info[i]) {
                    lion += 10 - i;
                } else {
                    if (info[i] != 0) {
                        apeach += 10 - i;
                    }
                }
            }

            int diff = lion - apeach;
            if (diff >= max) {
                result = Arrays.copyOf(arrows, 11);
                max = diff;
            }
            return;
        }

        for (int i = 0; i < 11; i++) {

            if (!visited[i]) {
                if (n > info[i]) {
                    visited[i] = true;
                    arrows[i] = info[i] + 1;
                    check(n - info[i] - 1, sum + 10 - i, visited, arrows, info);
                    visited[i] = false;
                    arrows[i] = 0;
                } else {
                    if (i == 10) {
                        arrows[i] = n;
                        check(0, sum, visited, arrows, info);
                        arrows[i] = 0;
                    }
                }
            }
        }
    }
}
