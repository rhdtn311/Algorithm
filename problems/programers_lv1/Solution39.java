package programers_lv1;

public class Solution39 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                index = 0;
                sb.append(c);
                continue;
            }

            sb.append(index % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
            index++;
        }

        return sb.toString();
    }
}
