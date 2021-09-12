package programers_lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class etc_45 {
    public long[] solution(int x, int n) {

        ArrayList<Long> list = new ArrayList<>();
        if (x == 0) {
            for(int i = 0; i < n; i++) {
                list.add(0L);
            }
        }
        else {
            for (long i = x; Math.abs(i) <= Math.abs((long) x * n); i += x) {
                list.add(i);
            }
        }

        return list.stream().mapToLong(Long::valueOf).toArray();
    }

    public static void main(String[] args) {
        etc_45 s = new etc_45();
        System.out.println(Arrays.toString(s.solution(-4, 5)));

    }
}
