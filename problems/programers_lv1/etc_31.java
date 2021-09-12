package programers_lv1;

public class etc_31 {
    // 프로그래머스 lv 1 : 수박수박수박수박수박수? (https://programmers.co.kr/learn/courses/30/lessons/12922)
    public String solution(int n) {
        String s = "";

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) { s += "박"; } else { s+= "수";}
        }
        return s;
    }
}
