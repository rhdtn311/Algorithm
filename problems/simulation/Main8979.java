package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        Nation[] nations = new Nation[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            nations[Integer.parseInt(input[0]) - 1] = new Nation(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
        }

        int count = 1;
        for (int i = 0; i < n; i++) {
            if (nations[k - 1].compareTo(nations[i]) > 0) {
                count++;
            }
        }

        System.out.println(count);

    }

    static class Nation implements Comparable<Nation> {
        int name;
        int g;
        int s;
        int b;

        public Nation(int name, int g, int s, int b) {
            this.name = name;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.g == o.g) {
                if (this.s == o.s) {
                    return o.b - this.b;
                }
                return o.s - this.s;
            }
            return o.g - this.g;
        }
    }
}
