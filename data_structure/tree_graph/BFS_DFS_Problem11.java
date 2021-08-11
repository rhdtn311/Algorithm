package tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_DFS_Problem11 {
    // 백준 2583 : 영역 구하기 (https://www.acmicpc.net/problem/2583) BFS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);     // 세로
        int n = Integer.parseInt(input[1]);     // 가로
        int numOfSquares = Integer.parseInt(input[2]);  // 사각형 수

        // 맵 만들기
        int map[][] = new int[m][n];
        for (int i = 0; i < numOfSquares; i++) {
            String[] coordinates = br.readLine().split(" ");
            for (int height = Integer.parseInt(coordinates[1]); height < Integer.parseInt(coordinates[3]); height++) {
                for (int width = Integer.parseInt(coordinates[0]); width < Integer.parseInt(coordinates[2]); width++) {
                    map[height][width] = 1;
                }
            }
        }

        int[] moveWidth = new int[] {-1, 1, 0, 0};
        int[] moveHeight = new int[] {0, 0, -1, 1};

        int numOfAreas = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int height = 0; height < m; height++) {
            for (int width = 0; width < n; width++ ) {
                if (map[height][width] == 0) {
                    int areas = 0;
                    numOfAreas++;

                    map[height][width] = 1;

                    // 영역의 초기 값
                    queue.add(height);
                    queue.add(width);

                    while (!queue.isEmpty()) {

                        // 현재 영역 좌표 값
                        int nowHeight = queue.poll();
                        int nowWidth = queue.poll();

                        areas++;
                        for (int i = 0; i < 4; i++) {
                            int nextHeight = nowHeight + moveHeight[i];
                            int nextWidth = nowWidth + moveWidth[i];

                            if (nextWidth < 0 || nextHeight < 0 || nextWidth > n - 1 || nextHeight > m - 1) {
                                continue;
                            }

                            if (map[nextHeight][nextWidth] == 1) {
                                continue;
                            }

                            map[nextHeight][nextWidth] = 1;
                            queue.add(nextHeight);
                            queue.add(nextWidth);
                        }
                    }
                    if (areas == 0) areas ++;
                    arrayList.add(areas);
                }
            }
        }

        Collections.sort(arrayList);
        System.out.println(numOfAreas);
        StringBuilder result = new StringBuilder();
        for (int area : arrayList) {
            result.append(area);
            result.append(" ");
        }
        System.out.println(result.toString().trim());
    }
}
