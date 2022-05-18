package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            bricks.add(new Brick(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        Collections.sort(bricks);

        int[] dp = new int[n];
        dp[0] = bricks.get(0).height;
        int answer = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            dp[i] = bricks.get(i).height;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(i).weight < bricks.get(j).weight && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = dp[i] + max;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

    static class Brick implements Comparable<Brick> {
        int area;
        int height;
        int weight;

        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.area - this.area;
        }
    }
}
