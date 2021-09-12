package programers_lv2;

import java.util.*;

public class etc_20 {
    // 프로그래머스 lv 2: 순위 검색
    public int[] solution(String[] info, String[] query) {

        Map<String, List<Integer>> map = new HashMap<>();

        // 조합
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            // 시프트 연산자
            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder string = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) {
                        string.append(split[j]);
                    }
                }
                map.computeIfAbsent(string.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        // 정렬
        for (List<Integer> value : map.values()) {
            value.sort(null);
        }

        int[] answer = new int[query.length];
        List<Integer> empty = new ArrayList<>();
        // 문자열 파싱
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].replaceAll("-", "").split(" and | ");
            String key = String.join("", split[0], split[1], split[2], split[3]);
            int score = Integer.parseInt(split[4]);

            List<Integer> list = map.getOrDefault(key, empty);

            // 이진탐색 (lower_bound)
            int start = 0;
            int end = list.size();
            while(start < end) {
                int mid = (start + end) / 2;
                if (list.get(mid) < score) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            answer[i] = list.size() - start;
        }
        return answer;
    }


    public static void main(String[] args) {

        etc_20 s = new etc_20();
        int[] solution = s.solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                                    new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
        System.out.println(Arrays.toString(solution));
    }
}
