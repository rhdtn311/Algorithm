package programers_lv1;

import java.util.HashMap;
import java.util.Map;

public class Solution10 {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        for (String part : participant) {
            if (map.containsKey(part)) {
                map.put(part, map.get(part) + 1);
            } else {
                map.put(part, 1);
            }
        }

        for (String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() != 0) {
                return stringIntegerEntry.getKey();
            }
        }

        return null;
    }
}
