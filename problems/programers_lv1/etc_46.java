package programers_lv1;

import java.util.HashMap;
import java.util.Map;

public class etc_46 {
    // 프로그래머스 lv 1 : 숫자 문자열과 영단어 (https://programmers.co.kr/learn/courses/30/lessons/81301)
    public int solution(String s) {

        Map<String, Integer> map = new HashMap<>();
        String input = "";
            String result = "";
            map.put("one", 1); map.put("two",2); map.put("three",3); map.put("four",4); map.put("five",5);
            map.put("six",6); map.put("seven",7); map.put("eight",8); map.put("nine",9); map.put("zero",0);

            char[] array = s.toCharArray();
            for (char c : array) {
                if(Character.isDigit(c)) {
                result += Character.getNumericValue(c);
                continue;
            }
            input += c;
            System.out.println(input);
            if (map.containsKey(input)) {
                result += map.get(input);
                input = "";
            }
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        etc_46 s = new etc_46();
        int one4seveneight = s.solution("23four5six7");
        System.out.println(one4seveneight);
    }
}
