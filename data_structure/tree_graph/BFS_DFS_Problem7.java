package tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Problem7 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int[] moveWidth = new int[] {-1,1,0,0};     // 이동할 가로 좌표
        int[] moveHeight = new int[] {0,0,-1,1};    // 이동할 세로 좌표
        for (int i = 0; i < testCase; i++) {
            String[] size = br.readLine().split(" ");
            int m = Integer.parseInt(size[0]);
            int n = Integer.parseInt(size[1]);
            int numOfLocation = Integer.parseInt(size[2]);

            // 맵 만들기
            int[][] map = new int[n][m];
            for (int j = 0; j < numOfLocation; j++) {
                String[] coordinate = br.readLine().split(" ");
                int mCoordinate = Integer.parseInt(coordinate[0]);
                int nCoordinate = Integer.parseInt(coordinate[1]);
                map[nCoordinate][mCoordinate] = 1;
            }

            //----------------------------------------------------------------------
            int count = 0;  // 배추 벌레 수

            Queue<Integer> queue = new LinkedList<>();  // 좌표를 넣을 큐
            for (int height = 0; height < n; height++) {
                for (int width = 0; width < m; width++) {
                    if (map[height][width] == 0 || map[height][width] == 2) continue;   // 전 좌표를 순회하며 값이 1인 좌표를 찾음

                    queue.add(height);  // 좌표의 세로 값
                    queue.add(width);   // 좌표의 가로 값
                    count++;    // 배추 벌레 추가

                    while(!queue.isEmpty()) {
                        int nowHeight = queue.poll();   // 현재 세로 값
                        int nowWidth = queue.poll();    // 현재 가로 값

                        for (int j = 0; j < 4; j++) {
                            int nextHeight = nowHeight + moveHeight[j];    // 다음 세로 값
                            int nextWidth = nowWidth + moveWidth[j];   // 다음 가로 값

                            // 다음 세로 값 or 다음 가로 값이 좌표를 벗어나면 continue
                            if (nextHeight < 0 || nextWidth < 0 || nextHeight > n - 1 || nextWidth > m - 1) continue;

                            // 다음 좌표가 0이거나 이미 배추 벌레가 처리 했다면(2) continue
                            if (map[nextHeight][nextWidth] == 0 || map[nextHeight][nextWidth] == 2) continue;

                            // 다음 좌표가 1이라면 2로 바꾸고 그 좌표의 상하좌우를 탐색하기 위해 큐에 삽입
                            if(map[nextHeight][nextWidth] == 1) {
                                map[nextHeight][nextWidth] = 2;
                                queue.add(nextHeight);
                                queue.add(nextWidth);
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }
}
