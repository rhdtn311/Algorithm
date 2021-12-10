package programers_lv1;

public class Solution34 {
    public int solution(int n) {

        int count = 0;
        boolean[] notPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (notPrime[i]) continue;

            count++;

            for (int j = i + i; j <= n; j += i) {
                notPrime[j] = true;
            }
        }

        return count;
    }
}
