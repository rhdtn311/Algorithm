package programers_lv1;

import java.util.*;

public class Solution15 {
    public static int[] solution(int N, int[] stages) {

        Stage[] arr = new Stage[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new Stage(i + 1, 0, 0);
        }

        for (int i = 0; i < stages.length; i++) {
            arr[stages[i]-1].player++;
        }

        List<Stage> list = new ArrayList<>();

        int now = stages.length;
        for (int i = 0; i < arr.length-1; i++) {
            arr[i].failure = now == 0 ? 0 : (double)arr[i].player / now;
            list.add(arr[i]);
            now -= arr[i].player;
        }

        Collections.sort(list);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = list.get(i).number;
        }

        return result;
    }

    static class Stage implements Comparable<Stage> {
        int number;
        double failure;
        int player;

        public Stage(int number, double failure, int player) {
            this.number = number;
            this.failure = failure;
            this.player = player;
        }

        @Override
        public int compareTo(Stage o) {
            if (this.failure > o.failure) {
                return -1;
            } else if (this.failure < o.failure) {
                return 1;
            } else {
                return this.number - o.number;
            }
        }
    }
}
