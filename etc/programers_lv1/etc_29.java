package programers_lv1;

public class etc_29 {
    // 프로그래머스 lv 1 : 서울에서 김서방 찾기 (https://programmers.co.kr/learn/courses/30/lessons/12919)
    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                return "김서방은 " + i +"에 있다";
            }
        }
        return null;
    }
}
