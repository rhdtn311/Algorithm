package programers_lv2;

import java.util.*;

public class Solution48 {

    public static int[] solution(String msg) {

        char A = 'A';
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf(A++), i);
        }

        List<Integer> list = new ArrayList<>();
        int now = 27;
        while(msg.length() > 0) {

            if (map.containsKey(msg)) {
                list.add(map.get(msg));
                break;
            }

            String str = "";
            for (int i = 1; i <= msg.length(); i++) {

                if (!map.containsKey(msg.substring(0, i))) {
                    map.put(msg.substring(0, i), now++);
                    str = msg.substring(0, i - 1);
                    msg = msg.substring(i - 1);
                    break;
                }
            }

            list.add(map.get(str));
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
