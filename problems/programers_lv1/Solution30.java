package programers_lv1;

public class Solution30 {
    boolean solution(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.toLowerCase(c) == 'p') {
                num++;
            } else if (Character.toLowerCase(c) == 'y' ) {
                num--;
            }
        }

        return num == 0;
    }
}
