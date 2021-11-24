package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1707version2 {

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

            color = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                ArrayList<Integer> arrayList = list.get(i);
                for (int value : arrayList) {
                    if (color[value] == 0) {
                        if (dfs(value, -1) == 0) {
                            System.out.println("NO");
                            continue outer;
                        }
                    }
                }
            }

            System.out.println("YES");
        }
    }

    static int dfs(int n, int nowColor) {

        if (color[n] == nowColor) {
            return 0;
        }

        if (color[n] == 0) {

            color[n] = nowColor == 1 ? -1 : 1;

            for (int value : list.get(n)) {
                int result = dfs(value, color[n]);

                if (result == 0) {
                    return 0;
                }
            }
        }

        return 1;
    }
}
