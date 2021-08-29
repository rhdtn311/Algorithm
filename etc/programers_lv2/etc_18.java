package programers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class etc_18 {
    // 프로그래머스 lv 2 : 게임 맵 최단거리
        public int solution(int[][] maps) {

            int result = bfs(maps);

            return result == Integer.MAX_VALUE ? -1 : result;
        }

        public int bfs(int[][] maps) {
            int[] moveHeight = new int[] {-1, 1, 0, 0};
            int[] moveWidth = new int[] {0,0,-1,1};

            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> depthQueue = new LinkedList<>();

            queue.add(0);
            queue.add(0);
            depthQueue.add(1);

            while(!queue.isEmpty()) {
                int nowHeight = queue.poll();
                int nowWidth = queue.poll();
                int nowDepth = depthQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextHeight = nowHeight + moveHeight[i];
                    int nextWidth = nowWidth + moveWidth[i];
                    int nextDepth = nowDepth + 1;

                    if (nextHeight < 0 || nextWidth < 0 || nextHeight > maps.length - 1|| nextWidth > maps[0].length - 1) {
                        continue;
                    }

                    if (maps[nextHeight][nextWidth] == 0) continue;

                    maps[nextHeight][nextWidth] = 0;

                    if (nextHeight == maps.length - 1&& nextWidth == maps[0].length - 1) {
                        return nextDepth;
                    }

                    queue.add(nextHeight);
                    queue.add(nextWidth);
                    depthQueue.add(nextDepth);

                }
            }

            return Integer.MAX_VALUE;

        }
}
