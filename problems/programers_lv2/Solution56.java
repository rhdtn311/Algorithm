package programers_lv2;

public class Solution56 {
    public String solution(int n, int t, int m, int p) {

        StringBuilder wholeStr = new StringBuilder();
        int num = 0;
        while (wholeStr.length() < m * t) {
            wholeStr.append(Integer.toString(num++, n));
        }

        StringBuilder result = new StringBuilder();
        for (int i = p - 1; i < wholeStr.length(); i += m) {
            result.append(Character.toUpperCase(wholeStr.charAt(i)));

            if (result.length() == t) {
                break;
            }
        }

        return result.toString();
    }
}
