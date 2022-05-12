package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main14 {

    static int n, m;
    static Point[] arr;

    static ArrayList<Point> homes = new ArrayList<>();
    static ArrayList<Point> stores = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        arr = new Point[m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int info = Integer.parseInt(input[j]);
                if (info == 1) homes.add(new Point(i, j));
                if (info == 2) stores.add(new Point(i, j));
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int start) {

        if (depth == m) {
            int sum = 0;
            for (int i = 0; i < homes.size(); i++) {
                int min = Integer.MAX_VALUE;
                Point home = homes.get(i);
                for (int j = 0; j < arr.length; j++) {
                    Point store = arr[j];
                    min = Math.min(min, Math.abs((home.x - store.x)) + Math.abs((home.y - store.y)));
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            arr[depth] = stores.get(i);
            dfs(depth + 1, i + 1);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
