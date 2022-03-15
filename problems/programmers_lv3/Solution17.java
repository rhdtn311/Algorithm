package programmers_lv3;

import java.util.*;

public class Solution17 {

    ArrayList<Integer>[] tree;
    boolean[] visited;
    long[] long_a;
    long result;

    public long solution(int[] a, int[][] edges) {

        tree = new ArrayList[a.length];
        long_a = new long[a.length];
        visited = new boolean[a.length];
        result = 0;

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            tree[i] = (new ArrayList<>());
            long_a[i] = a[i];
        }

        if (sum != 0) {
            return -1;
        }

        for (int[] edge : edges) {
            tree[(edge[0])].add(edge[1]);
            tree[(edge[1])].add(edge[0]);
        }

        dfs(0);

        return result;
    }

    long dfs(int now) {
        visited[now] = true;

        for (int i = 0; i < tree[now].size(); i++) {
            int next = tree[now].get(i);
            if (!visited[next]) {
                long_a[now] += dfs(next);
            }
        }


        result += Math.abs(long_a[now]);

        return long_a[now];
    }
}