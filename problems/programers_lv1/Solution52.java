package programers_lv1;

public class Solution52 {
    public long[] solution(int x, int n) {
        long[] result = new long[n];

        for (int i = 1; i <= n; i++) {
            result[i-1] = x * i;
        }

        return result;
    }
}
