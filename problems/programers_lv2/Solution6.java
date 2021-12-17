package programers_lv2;

public class Solution6 {
    public static String solution(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {

            int remain = n % 3;

            sb.append(remain == 1 ? 1 : (remain == 2 ? 2 : 4));

            n /= 3;
            if (remain == 0) {
                n--;
            }
        }

        return sb.reverse().toString();
    }
}
