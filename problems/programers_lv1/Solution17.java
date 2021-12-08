package programers_lv1;

public class Solution17 {
    public static int solution(int n) {

        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            sb.append(n % 3);
            n /= 3;
        }

        String reverse = sb.reverse().toString();

        int num = 0;
        for (int i = 0; i < reverse.length(); i++) {
            num += Character.getNumericValue(reverse.charAt(i)) * Math.pow(3, i);
        }

        return num;
    }
}
