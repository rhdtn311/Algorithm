package tree_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Problem4 {

    // 프로그래머스 lv3 : 네트워크 (https://programmers.co.kr/learn/courses/30/lessons/43162)
        public static int solution(int n, int[][] computers) {
        // BFS를 이용
            Queue<Integer> queue = new LinkedList<>();

            int count = 0;  // 네트워크의 수
            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[0].length; j++) {

                    if (computers[i][j] == 1) { // 네트워크에 속해있는 노드를 찾는다.
                        count++;
                        computers[i][j] = 2;    // 해당 노드를 2로 만듬

                        queue.add(j);   // 큐에 기준 노드와 연결돼있는 노드 추가
                        while (!queue.isEmpty()) {
                            int linkedComputer = queue.poll();  // 큐에서 연결된 노드들을 차례로 꺼네 또 다른 연결돼 있는 노드를 꺼낸다.
                            for (int k = 0; k < computers[0].length; k++) {
                                if (computers[linkedComputer][k] == 1) {    // 연결 노드를 2로 바꾸고 큐에 넣음
                                    computers[linkedComputer][k] = 2;
                                    if (linkedComputer != k) {
                                        queue.add(k);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(computers));
            return count;
        }

    // DFS 이용
    public void dfs(int[][] computers, int computer, boolean[] visited) {

            visited[computer] = true;   // 해당 컴퓨터의 방문 기록을 true

            for (int i = 0; i < computers.length; i++) {
                if (computers[computer][i] == 1 && !visited[i]) {   // 해당 컴퓨터가 i 컴퓨터를 방문했고, 아직 i 컴퓨터를 방문한 적 없다면
                    dfs(computers, i, visited); // i 컴퓨터를 방문하여 i 컴퓨터와 연관된 컴퓨터를 방문처리
                }
            }
    }

    public int solution2(int n, int[][] computers) {
        int count = 0;  // 네트워크의 수
        boolean[] visited = new boolean[n]; // 컴퓨터에 방문 기록을 확인하는 배열

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // 해당 컴퓨터를 방문하지 않았다면
                dfs(computers, i, visited); // 해당 컴퓨터를 dfs 로 탐색
                count++;
            }
        }
        return count;
    }
}
