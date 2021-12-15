package programers_lv2;

public class Solution1 {
    public int solution(String s) {
        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {

            String now = "";
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 0; j < s.length(); j += i) {

                if (j + i > s.length()) {
                    sb.append(s.substring(j));
                    break;
                }

                String compare = s.substring(j, j + i);

                if (now.equals(compare)) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(now);
                    } else {
                        sb.append(count).append(now);
                    }

                    count = 1;
                    now = compare;
                }
            }

            if (count != 1) {
                sb.append(count).append(now);
            } else {
                sb.append(now);
            }

            min = Math.min(min, sb.length());
        }

        return min;
    }
}
