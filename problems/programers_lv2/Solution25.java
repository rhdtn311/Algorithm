package programers_lv2;

import java.util.*;

public class Solution25 {

    public static int[] solution(String[] info, String[] query) {

        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int k = 0; k < info.length; k ++) {

            String[] strings = info[k].split(" ");
            int score = Integer.parseInt(strings[4]);

            for (int i = 0; i < 1 << 4; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) {
                        sb.append(strings[j]);
                    }
                }
                map.computeIfAbsent(sb.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        for (ArrayList<Integer> values : map.values()) {
            values.sort(null);
        }

        ArrayList<Integer> empty = new ArrayList<>();
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].replaceAll("-", "").split(" and | ");
            String s = String.join("", split[0], split[1], split[2], split[3]);
            int score = Integer.parseInt(split[4]);

            System.out.println(s);
            ArrayList<Integer> scores = map.getOrDefault(s, empty);
            int start = 0;
            int end = scores.size();
            while (start < end) {
                int mid = (start + end) / 2;

                if (scores.get(mid) >= score) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            result[i] = scores.size() - start;
        }


        return result;
    }
}
