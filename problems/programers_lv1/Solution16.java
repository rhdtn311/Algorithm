package programers_lv1;

public class Solution16 {
    public int solution(int left, int right) {

        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                sum += i;
            } else {
                sum -= i;
            }
        }

        return sum;
    }

    static boolean check(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return count % 2 == 0;
    }
}
