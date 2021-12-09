package programers_lv1;

public class Solution21 {
    public int solution(int n) {

        for (int i = 3; i <= n; i++) {
            if (n % i == 1) {
                return i;
            }
        }

        return 0;
    }
}
