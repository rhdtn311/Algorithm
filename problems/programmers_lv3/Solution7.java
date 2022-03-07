package programmers_lv3;

import java.util.*;

public class Solution7 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();
//        int[] solution1 = solution.solution(new String[]{"A", "A", "A", "B", "B"});
//        int[] solution1 = solution.solution(new String[]{"A"});
        int[] solution1 = solution.solution(new String[]{"A","B","B","B","B","B","B","C","B","A"});
        System.out.println(Arrays.toString(solution1));
    }

    public int[] solution(String[] gems) {

        int[] answer = new int[] {0, gems.length};

        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);

        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int kind = set.size();

        int left = 0; int right = 0;
        while (left <= right) {

            if (map.size() < kind) {
                right++;

                if (right <= gems.length - 1) {
                    map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                }

            } else {
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                } else if (left < answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }

                if (map.get(gems[left]) > 1) {
                    map.put(gems[left], map.get(gems[left]) - 1);
                } else {
                    map.remove(gems[left]);
                }
                left++;
            }

            if (right >= gems.length) {
                break;
            }
        }

        answer[0] += 1; answer[1] += 1;
        return answer;
    }
}
