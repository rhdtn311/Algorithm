package baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            Coordinate coordinate = new Coordinate(x, y);
            arrayList.add(coordinate);
        }

        Collections.sort(arrayList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i).x).append(" ").append(arrayList.get(i).y).append("\n");
        }

        System.out.println(sb);
    }

    public static class Coordinate implements Comparable<Coordinate> {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate c) {
            if (this.x > c.x) {
                return 1;
            } else if (this.x < c.x) {
                return -1;
            } else {
                if (this.y > c.y) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
