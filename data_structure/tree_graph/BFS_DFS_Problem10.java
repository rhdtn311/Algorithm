package tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_DFS_Problem10 {
    // 백준 2583 : 영역 구하기 (https://www.acmicpc.net/problem/2583) solved with DFS
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

        int numOfAreas = 0; // 총 영역의 수
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int height = 0; height < m; height++) {
            for (int width = 0; width < n; width++) {
                if (map[height][width] == 0) {  // 빈 영역 찾기
                    numOfAreas++;
                    int dfs = dfs(height, width, map, 0);
                    arrayList.add(dfs);
                }
            }
        }
        System.out.println(numOfAreas);
        Collections.sort(arrayList);
        StringBuilder answer = new StringBuilder();
        for (int i : arrayList) {
            answer.append(i);
            answer.append(" ");
        }

        System.out.println(answer.toString().trim());
    }

    public static int dfs(int height, int width, int[][] map, int result) {

        // 움직이는 방향
        int[] moveWidth = new int[]{-1, 1, 0, 0};
        int[] moveHeight = new int[]{0, 0, -1, 1};

        map[height][width] = 1;

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int nextWidth = width + moveWidth[i];   // 가로로 이동
            int nextHeight = height + moveHeight[i];    // 세로로 이동

            // 이동 후 맵을 넘어간다면 continue
            if (nextWidth < 0 || nextHeight < 0 || nextHeight > map.length - 1 || nextWidth > map[0].length - 1) continue;

            // 이동할 수 없는 영역이라면 continue
            if (map[nextHeight][nextWidth] == 1) continue;

            // dfs의 return이 여기서 이루어 지기 때문에 answer에 값이 누적된다.
            answer += dfs(nextHeight, nextWidth, map, answer);
            System.out.println("answer : " + answer);

        }

        return answer + 1;
    }
}
