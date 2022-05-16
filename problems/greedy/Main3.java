package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arrive[] arrives = new Arrive[n*2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arrives[index++] = new Arrive(Integer.parseInt(input[0]), 's');
            arrives[index++] = new Arrive(Integer.parseInt(input[1]), 'e');
        }

        Arrays.sort(arrives);

        int count = 0;
        int answer = 0;
        for (int i = 0; i < n * 2; i++) {
            if (arrives[i].se == 'e') {
                count--;
            } else {
                count++;
                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }

    static class Arrive implements Comparable<Arrive> {
        int time;
        char se;

        public Arrive(int time, char se) {
            this.time = time;
            this.se = se;
        }

        @Override
        public int compareTo(Arrive o) {
            if (this.time == o.time) {
                return this.se - o.se;
            } else {
                return this.time - o.time;
            }
        }
    }
}
