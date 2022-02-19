package programers_lv2;

public class Solution60 {
    public static int solution(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = i;
            int plus = i;

            while (true) {
                if (sum == n) {
                    count++;
                    break;
                } else if (sum > n) {
                    break;
                }

                sum += ++plus;
            }
        }

        return count;
    }
}
