package programers_lv1;

// 65 ~ 90
// 97 ~ 122
public class Solution37 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
                continue;
            }

            if (c >= 65 && c <= 90) {
                if (c + n > 90) {
                    sb.append((char) (64 + c + n - 90));
                } else {
                    sb.append((char) (c + n));
                }
            } else {
                if (c + n > 122) {
                    sb.append((char) (96 + c + n - 122));
                } else {
                    sb.append((char) (c + n));
                }
            }
        }

        return sb.toString();
    }
}
