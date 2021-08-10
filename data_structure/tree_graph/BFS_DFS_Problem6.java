package tree_graph;

import java.io.*;
import java.util.*;

public class BFS_DFS_Problem6 {
    // 백준 11724번 : 연결 요소의 개수 (https://www.acmicpc.net/problem/11724)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int numOfNodes = Integer.parseInt(s[0]);
        int numOfEdges = Integer.parseInt(s[1]);

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i <= numOfNodes; i++) {
            arrayList.add(new ArrayList<>());
        }

        for (int i = 0; i < numOfEdges; i++) {
            String[] linkedNodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(linkedNodes[0]);
            int node2 = Integer.parseInt(linkedNodes[1]);

            arrayList.get(node1).add(node2);
            arrayList.get(node2).add(node1);
        }

        // 3 2 | 1 3 | 2 3
        boolean[] isVisited = new boolean[numOfNodes + 1];
        int count = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            if (!isVisited[i]) {
                count++;
                dfs(i, isVisited, arrayList);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int node, boolean[] isVisited, ArrayList<ArrayList<Integer>> arrayList) {

        if (isVisited[node]) return;

        ArrayList<Integer> nodes = arrayList.get(node);
        isVisited[node] = true;
        for (int i = 0; i < nodes.size(); i++) {
            Integer nextNode = nodes.get(i);
            dfs(nextNode, isVisited, arrayList);
        }
    }
}
