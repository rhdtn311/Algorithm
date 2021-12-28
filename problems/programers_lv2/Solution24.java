package programers_lv2;

public class Solution24 {
    public int solution(int n, int a, int b) {

        int round = 1;

        while (true) {
            int max = Math.max(a, b);
            int min = Math.min(a, b);

            if (max % 2 == 0 && max - 1 == min) {
                return round;
            }

            round++;
            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;

        }
    }
}
