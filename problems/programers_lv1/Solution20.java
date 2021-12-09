package programers_lv1;

public class Solution20 {
    public int solution(int[][] sizes) {

        int most = 0;
        int minMost = 0;
        for (int i = 0; i < sizes.length; i++) {
            most = Math.max(most, Math.max(sizes[i][0], sizes[i][1]));
            minMost = Math.max(minMost, Math.min(sizes[i][0], sizes[i][1]));
        }
        return most * minMost;
    }
}
