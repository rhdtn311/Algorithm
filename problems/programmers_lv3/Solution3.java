package programmers_lv3;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
//        int solution = solution3.solution(new int[][]{{0, 10}, {2, 12}, {9, 19}, {15, 17}});
//        int solution = solution3.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
//        int solution = solution3.solution(new int[][]{{0, 1}});
//        int solution = solution3.solution(new int[][]{{1000, 1000}});
//        int solution = solution3.solution(new int[][]{{0, 1}, {0, 1}, {0, 1}});
//        int solution = solution3.solution(new int[][]{{0, 1}, {0, 1}, {0, 1}, {0, 1}});
//        int solution = solution3.solution(new int[][]{{0, 1}, {1000, 1000}});
//        int solution = solution3.solution(new int[][]{{0, 3}, {4, 4}, {5, 3}, {4, 1}});
//        int solution = solution3.solution(new int[][]{{0, 20}, {3, 4}, {3, 5}, {17, 2}});
//        int solution = solution3.solution(new int[][]{{0, 10}, {2, 10}, {25, 2}, {25, 10}});
//        int solution = solution3.solution(new int[][]{{0, 1}, {1, 2}, {500, 6}});
//        int solution = solution3.solution(new int[][]{{3, 6}, {3, 1}});
//        int solution = solution3.solution(new int[][]{{0, 5}, {1, 2}, {5, 5}});
//        int solution = solution3.solution(new int[][]{{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}});
//          int solution = solution3.solution(new int[][]{{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}});
        int solution = solution3.solution(new int[][]{{0, 10}, {4, 10}, {5, 11}, {15, 2}});
        System.out.println(solution);

    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int sum = 0;
        int index = 0;
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        while (index < jobs.length || !pq.isEmpty()) {

            while (index < jobs.length && time >= jobs[index][0]) {
                pq.offer(jobs[index++]);
            }

            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] job = pq.poll();
                sum += time - job[0] + job[1];
                time += job[1];
            }
        }

        return sum / jobs.length;
    }
}
