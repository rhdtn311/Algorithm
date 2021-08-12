package programers_lv1;

public class etc_21 {
    // 프로그래머스 lv 1 : 가운데 글자 가져오기
    public String solution(String s) {

        int standard = 0;
        String result = "";
        if (s.length() % 2 == 0) {
            standard = s.length() / 2 -1 ;
            s = String.valueOf(s.charAt(standard)) +
                String.valueOf(s.charAt(standard+1));

        } else {
            standard = s.length() / 2;
            s = String.valueOf(s.charAt(standard));
        }
        return s;
    }
}
