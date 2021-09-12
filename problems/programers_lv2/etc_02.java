package programers_lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class etc_02 {
    // 프로그래머스 lv 2: 카카오 프렌즈 컬러링북 (https://programmers.co.kr/learn/courses/30/lessons/1829)
    public int[] solution(int m, int n, int[][] picture) {

        ArrayList<Integer> result = new ArrayList<>();
        int numOfAreas = 0;

        // 방문 기록 체크
        boolean[][] visited = new boolean[m][n];

        for (int height = 0; height < m; height++) {
            for (int width = 0; width < n; width++) {
                // 방문한 적 없고 여백인 구역을 찾음
                if (!visited[height][width] && !(picture[height][width] == 0)) {
                    numOfAreas++;   // 영역 추가
                    int count = dfs(height, width, picture, visited);
                    result.add(count);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < result.size(); i++) {
            if (max < result.get(i)) max = result.get(i);
        }

        int[] answer = new int[] {numOfAreas, max};

        return answer;
    }

    // dfs
    public int dfs(int height, int width, int[][] picture, boolean[][] visited) {
        int[] moveHeight = new int[] {-1, 1, 0, 0};
        int[] moveWidth = new int[] {0, 0, -1, 1};

        visited[height][width] = true;    // 방문 표시
        int nowValue = picture[height][width];  // 현재 순회 하는 영역의 색
        int count = 0;
        // 현재 영역을 상하좌우로 움직여 봄
        for (int i = 0; i < 4; i++) {
            int nextHeight = height + moveHeight[i];
            int nextWidth = width + moveWidth[i];

            // 다음 이동 영역이 그림의 범위를 넘어간다면 continue
            if (nextHeight < 0 || nextWidth < 0 || nextHeight > picture.length - 1 || nextWidth > picture[0].length - 1) {
                continue;
            }

            // 다음 이동 영역의 색이 현재 탐색하는 영역의 색과 다르다면 (다른 영역이라면) continue
            if (nowValue != picture[nextHeight][nextWidth]) continue;
            // 다음 이동 영역을 이미 탐색한 적 있다면 continue
            if (visited[nextHeight][nextWidth]) continue;

            // 재귀적으로 탐색하고 + 1
            count += dfs(nextHeight, nextWidth, picture, visited);
        }

        return count + 1;
    }
}
