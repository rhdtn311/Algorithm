package programers_lv1;

public class Solution24 {
    public String solution(String s) {
        if (s.length() % 2 == 0) {
            int mid1 = s.length() / 2 - 1;
            int mid2 = s.length() / 2;

            return String.valueOf(s.charAt(mid1))  + String.valueOf(s.charAt(mid2));
        } else {
            int mid = s.length() / 2;
            return String.valueOf(s.charAt(mid));
        }
    }
}
