package programers_lv2;

import java.util.*;

public class Solution38 {

    public static int[] solution(int n, String[] words) {

        int[] result = new int[]{0, 0};

        Set<String> set = new HashSet<>(List.of(words[0]));
        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            if (prev.charAt(prev.length() - 1) != words[i].charAt(0) || set.contains(words[i])) {
                result[0] = i % n + 1;
                result[1] = i / n + 1;
                break;
            }
            set.add(words[i]);
            prev = words[i];
        }
        return result;
    }
}
