package programers_lv1;

public class Solution32 {
    public boolean solution(String s) {
        if ((s.length() == 4 || s.length() == 6)) {
            try {
                Integer.valueOf(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
