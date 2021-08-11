package tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Problem8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstInput = br.readLine().split(" ");

        int n = Integer.parseInt(firstInput[0]);    // 세로
        int m = Integer.parseInt(firstInput[1]);    // 가로

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String values = br.readLine();
            for (int j = 0; j < m; j++) {
                int value = Character.getNumericValue(values.charAt(j));
                map[i][j] = value;
            }
        }

        int[] moveWidth = new int[] {-1, 1, 0, 0};  // 가로로 한 칸 움직임
        int[] moveHeight = new int[] {0, 0, -1, 1}; // 세로로 한 칸 움직임

        // 큐에서 현재 가로 좌표와 세로 좌표를 꺼냄
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);

        // 현재 좌표가 최소 값으로 칸 이동했는지 저장하는 큐
        Queue<Integer> moveQueue = new LinkedList<>();
        moveQueue.add(1);

        while(!queue.isEmpty()) {
            // 현재 가로 좌표와 세로 좌표
            int width = queue.poll();
            int height = queue.poll();

            // 현재 좌표의 이동 수
            int moveNum = moveQueue.poll();

            // 현재 좌표가 목표 좌표면 break;
            if (height == n - 1 && width == m - 1) {
                System.out.println(moveNum);
                break;
            }

            // 현재 좌표에 상하좌우를 탐색
            for (int i = 0; i < 4; i++) {
                int nextWidth = width + moveWidth[i];
                int nextHeight = height + moveHeight[i];

                if (nextWidth < 0 || nextHeight < 0 || nextWidth > m - 1 || nextHeight > n - 1) continue;

                if (map[nextHeight][nextWidth] == 0) continue;

                map[nextHeight][nextWidth] = 0;
                queue.add(nextWidth);
                queue.add(nextHeight);

                // 다음 이동 거리는 현재 이동거리의 + 1
                int nextMove = moveNum + 1;
                moveQueue.add(nextMove);

            }
        }
    }
}