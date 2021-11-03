package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] city = new long[n];
        long[] value = new long[n - 1];

        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            value[i] = Long.parseLong(values[i]);
        }

        String[] cities = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            city[i] = Long.parseLong(cities[i]);
        }

        long cost = 0;
        long prev = city[0];
        for (int i = 1; i < n; i++) {
            cost += prev * value[i - 1];

            if (prev >= city[i]) {
                prev = city[i];
            }
        }

        System.out.println(cost);
    }
}
