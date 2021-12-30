package programers_lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution29 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int sum = 1;
        for (int v : map.values()) {
            sum *= (v + 1);
        }

        return sum - 1;
    }
}
