package tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_DFS_Problem2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int[][] graph = new int[n][m];

        for (int i = 0; i < k; i++) {
            BufferedReader xy = new BufferedReader(new InputStreamReader(System.in));
            String[] s = xy.readLine().split(" ");

            changeGraph(graph, Integer.parseInt(s[0]), Integer.parseInt(s[1]),
                    Integer.parseInt(s[2]), Integer.parseInt(s[3]));


        }

        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        ArrayList<Integer> arrayList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int count = 0;

                if (graph[x][y] == 0) {
                    queue.add(x);
                    queue.add(y);
                } else {
                    continue;
                }

                while(!queue.isEmpty()) {
                    int xValue = queue.poll();
                    int yValue = queue.poll();

                    graph[xValue][yValue] = 2;

                    for (int next = 0; next < 4; next ++) {
                        int nx = xValue + dx[next];
                        int ny = yValue + dy[next];

                        if (nx < 0 || ny < 0 || nx > n-1 || ny > m-1) {
                            continue;
                        }

                        if (graph[nx][ny] == 1 || graph[nx][ny] == 2) {
                            continue;
                        }

                        if (graph[nx][ny] == 0) {
                            graph[nx][ny] = 2;
                            count ++;
                            queue.add(nx);
                            queue.add(ny);
                        }
                    }
                }
                arrayList.add(count+1);
            }
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));

            if (i != arrayList.size()-1) {
                System.out.print(" ");
            }

        }
    }

    public static void changeGraph(int[][] graph, int startX, int startY, int endX, int endY) {
        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                if (graph[x][y] == 1) {
                    continue;
                }
                graph[x][y] = 1;
            }
        }
    }

}
