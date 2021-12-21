package programers_lv2;

import java.util.*;

public class Solution14 {
    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> multiSet1 = new HashMap<>();
        Map<String, Integer> multiSet2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {

            if (str1.charAt(i) >= 97 && str1.charAt(i) <= 122 && str1.charAt(i + 1) >= 97 && str1.charAt(i + 1) <= 122) {
                String element = str1.substring(i, i + 2);
                multiSet1.put(element, multiSet1.getOrDefault(element, 0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.charAt(i) >= 97 && str2.charAt(i) <= 122 && str2.charAt(i + 1) >= 97 && str2.charAt(i + 1) <= 122) {
                String element = str2.substring(i, i + 2);
                multiSet2.put(element, multiSet2.getOrDefault(element, 0) + 1);

            }
        }

        if (multiSet1.size() == 0 && multiSet2.size() == 0) {
            return 65536;
        }

        int intersection = 0;
        int union = 0;
        for (Map.Entry<String, Integer> entry : multiSet1.entrySet()) {
            if (multiSet2.containsKey(entry.getKey())) {
                intersection += Math.min(multiSet1.get(entry.getKey()), multiSet2.get(entry.getKey()));
                union += Math.max(multiSet1.get(entry.getKey()), multiSet2.get(entry.getKey()));
            } else {
                union += multiSet1.get(entry.getKey());
            }
        }

        for (Map.Entry<String, Integer> entry : multiSet2.entrySet()) {
            if (!multiSet1.containsKey(entry.getKey())) {
                union += multiSet2.get(entry.getKey());
            }
        }


        return (int)((double) intersection / union * 65536);
    }

}
