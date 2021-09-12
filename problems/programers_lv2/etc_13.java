package programers_lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class etc_13 {
    // 프로그래머스 lv 2 : 거리두기 확인하기 (https://programmers.co.kr/learn/courses/30/lessons/81302)
    public int[] solution(String[][] places) {

        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            // 응시자가 없을 경우를 확인하기 위한 boolean
            boolean checkCandidate = false;
             breakPoint : for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    // 지원자가 앉아 있는 곳을 찾아서 checkLocation(bfs) 메서드를 실행
                    if (places[i][j].charAt(k) == 'P') {
                        checkCandidate = true;
                        int result = checkLocation(places[i], j, k, 0);
                        answer[i] = result;
                        if (result == 0) {
                            // 결과가 0이면 다음 응시장으로
                            break breakPoint;
                        }
                    }
                }
            }
             if (!checkCandidate) {
                 answer[i] = 1;
             }
        }

        return answer;
    }

    // bfs
    public int checkLocation (String[] place, int height, int width, int distance) {

        int[] moveWidth = new int[] {-1,1, 0,0};
        int[] moveHeight = new int[] {0,0,-1,1};

        // 세로 값, 가로 값, 거리를 넣을 큐를 생성
        Queue<Integer> heightQueue = new LinkedList<>();
        Queue<Integer> widthQueue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();

        heightQueue.add(height);
        widthQueue.add(width);
        distanceQueue.add(distance);

        // 방문 처리를 위한 배열
        boolean[][] visited = new boolean[5][5];

        while(!heightQueue.isEmpty()) {
            int nowHeight = heightQueue.poll();
            int nowWidth = widthQueue.poll();
            int nowDistance = distanceQueue.poll();

            // 방문 처리
            visited[nowHeight][nowWidth] = true;

            // 맨허튼 거리가 3이라면 넘어감
            if (nowDistance == 3) continue;

            for (int i = 0; i < 4; i++) {

                int nextHeight = nowHeight + moveHeight[i];
                int nextWidth = nowWidth + moveWidth[i];

                if (nextHeight < 0 || nextWidth < 0 || nextHeight > 4 || nextWidth > 4) continue;

                // 이미 방문 했다면 넘어감
                if (visited[nextHeight][nextWidth]) continue;
                // 다음 위치가 X라면 넘어감
                if (place[nextHeight].charAt(nextWidth) == 'X') continue;

                // 이동거리 + 1
                int nextDistance = nowDistance + 1;
                if (nextDistance == 3) continue;
                // 다음 위치가 "P"면 방역 위반
                if (place[nextHeight].charAt(nextWidth) == 'P') {
                        return 0;
                }

                heightQueue.add(nextHeight);
                widthQueue.add(nextWidth);
                distanceQueue.add(nextDistance);
            }
        }

        return 1;
    }
}
