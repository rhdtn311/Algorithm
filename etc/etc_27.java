import java.util.*;

public class etc_27 {
    // 프로그래머스 lv 1 : 문자열 내림차순으로 배치하기 (https://programmers.co.kr/learn/courses/30/lessons/12917_
    public String solution(String s) {
        ArrayList<Character> lower = new ArrayList<>();
        ArrayList<Character> upper = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            if(65 <= s.charAt(i) && s.charAt(i) <= 90) {
                upper.add(s.charAt(i));
            } else {
                lower.add(s.charAt(i));
            }
        }
        lower.sort(Comparator.reverseOrder());
        upper.sort(Comparator.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (char c : lower) {
            result.append(c);
        }
        for (char c : upper) {
            result.append(c);
        }

        return result.toString();
    }


    public static void main(String[] args) {
        etc_27 s = new etc_27();
        String zbcdefg = s.solution("Zbcdefg");
        System.out.println(zbcdefg);
    }
}
