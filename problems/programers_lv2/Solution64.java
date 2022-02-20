package programers_lv2;

import java.util.Locale;

public class Solution64 {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        boolean isBlank = true;
        for (char c : s.toCharArray()) {

            if (c == ' ') {
                isBlank = true;
                sb.append(c);
                continue;
            }

            if (isBlank) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }

            isBlank = false;
        }

        return sb.toString();
    }
}
