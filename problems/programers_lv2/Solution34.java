package programers_lv2;

import java.util.Arrays;

public class Solution34 {

    static int max = 0;

    public static int solution(int k, int[][] dungeons) {

        permutation(dungeons, new boolean[dungeons.length], k, 0);

        return max;
    }

    static void permutation(int[][] dungeons, boolean[] visited, int k, int depth) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                permutation(dungeons, visited, k - dungeons[i][1], depth + 1);
                visited[i] = false;
            }
        }

        max = Math.max(max, depth);
    }
}
