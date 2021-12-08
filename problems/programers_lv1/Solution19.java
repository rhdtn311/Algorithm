package programers_lv1;

import java.util.*;

public class Solution19 {

    static Set<Integer> set = new TreeSet<>();

    public int[] solution(int[] numbers) {

        combination(numbers, 0, 0, 0);

        return set.stream().mapToInt(Integer::valueOf).toArray();
    }

    static void combination(int[] numbers, int start, int depth, int num) {

        if (depth == 2) {
            set.add(num);
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            combination(numbers, i + 1, depth + 1, num + numbers[i]);
        }

    }
}
