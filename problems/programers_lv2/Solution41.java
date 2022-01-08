package programers_lv2;

import java.util.*;

public class Solution41 {

    static List<ArrayList<Integer>> list = new ArrayList<>();

    public static int solution(int n, int[][] wires) {

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        int result = n;
        for (int[] wire : wires) {
            List<Integer> cut = List.of(wire[0], wire[1]);

            int count = bfs(wire[0], cut, new boolean[n + 1]);
            result = Math.min(result, Math.abs(n - count - count));
        }
        return result;
    }

    static int bfs(int start, List<Integer> cut, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            count++;

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);

                if (visited[next] || (cut.contains(start) && cut.contains(next))) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);
            }
        }
        return count;
    }
}
