package programers_lv2;

public class Solution46 {
    public int solution(int n) {

        int count = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n - 1;
                count++;
            }
        }
        return count;
    }
}
