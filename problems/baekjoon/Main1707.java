package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1707 {

    static int[] color;

    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        outer : while(T-->0){
            String[] VE = br.readLine().split(" ");
            int V = Integer.parseInt(VE[0]);
            int E = Integer.parseInt(VE[1]);

            list = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < E; i++) {
                String[] input = br.readLine().split(" ");
                list.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
                list.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
            }
//            System.out.println(list);

            color = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                ArrayList<Integer> arrayList = list.get(i);
                for (int value : arrayList) {
                    if (color[value] == 0) {
                        if (bfs(value) == 0) {
                            System.out.println("NO");
                            System.out.println(Arrays.toString(color));
                            continue outer;
                        }
                    }
                }
            }

            System.out.println("YES");
        }
    }

    static int bfs(int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        color[n] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nowColor = color[now];

            for (int next : list.get(now)) {

                if (color[next] == 0) {
                    color[next] = nowColor == 1 ? -1 : 1;
                    queue.add(next);
                    continue;
                }

                if (color[next] == nowColor) {
                    return 0;
                }


            }
        }
        return 1;
    }
}
