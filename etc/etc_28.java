public class etc_28 {
    // 프로그래머스 lv 1 : 문자열 다루기 기본
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0;  i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
