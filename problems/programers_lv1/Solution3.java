package programers_lv1;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static int solution(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three",3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                word.append(c);
                if (map.containsKey(word.toString())) {
                    result.append(map.get(word.toString()));
                    word = new StringBuilder();
                }
            }
        }

        return Integer.parseInt(result.toString());
    }
}
