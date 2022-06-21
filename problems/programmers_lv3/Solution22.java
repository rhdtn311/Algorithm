package programmers_lv3;

import java.util.Arrays;

public class Solution22 {

    int[][] weaks;
    int answer = Integer.MAX_VALUE;
    boolean findAnswer = false;

    public int solution(int n, int[] weak, int[] dist) {
        weaks = new int[weak.length][weak.length];

        makeWeaks(weak, n);

        for (int i = 1; i <= weak.length; i++) {
            makeDistPermutation(new int[i], new boolean[dist.length], 0, i, dist);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    void makeDistPermutation(int[] temp, boolean[] visited, int depth, int limit, int[] dist) {

        if (findAnswer) return;

        if (depth == limit) {
            check(temp);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = dist[i];
                makeDistPermutation(temp, visited, depth + 1, limit, dist);
                visited[i] = false;
            }
        }
    }

    void check(int[] temp) {

        for (int[] weak : weaks) {
            for (int i = 0; i < temp.length;) {
                int before = 0;
                int count = 1;
                for (int j = 1; j < weak.length; j++) {
                    if (weak[j] - weak[before] > temp[i]) {
                        before = j;
                        i++;
                    }
                    if (i >= temp.length) break;
                    count++;
                }

                if (count == weak.length) {
                    answer = temp.length;
                    findAnswer = true;
                    return;
                }
            }
        }
    }

    void makeWeaks(int[] weak, int n) {

        for (int i = 0; i < weak.length; i++) {

            boolean flag = true;
            int idx = i;
            int t = 0;
            int wi = 0;
            int[] w = new int[weak.length];
            while (t++ < weak.length) {

                if (idx >= weak.length && flag) {
                    idx = 0;
                    flag = false;
                }
                w[wi++] = flag ? weak[idx] : weak[idx] + n;
                idx++;
            }
            weaks[i] = w;
        }
    }

    public static void main(String[] args) {
        Solution22 s = new Solution22();
//        int solution = s.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4});
//        int solution = s.solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7});
        int solution = s.solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30});
        System.out.println(solution);

    }
}
