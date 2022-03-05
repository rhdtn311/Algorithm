package programmers_lv3;

import java.util.*;

public class Solution4version2 {

    static Map<Integer, Set<Integer>> dp = new HashMap<>();

    public int solution(int N, int number) {

        for (int i = 0; i <= 8; i++) {
            dp.put(i, new HashSet<>());
        }

        dp.get(1).add(N);
        for (int i = 1; i <= 8; i++) {
            calculate(i, N);
        }

        for (Integer key : dp.keySet()) {
            for (Integer value : dp.get(key)) {
                if (value == number) {
                    return key;
                }
            }
        }

        return -1;
    }

    static void calculate(int depth, int N) {

        for (int i = 1; i < depth; i++) {
            Set<Integer> set1 = dp.get(i);
            Set<Integer> set2 = dp.get(depth - i);

            Set<Integer> nowSet = dp.get(depth);
            for (Integer value1 : set1) {
                for (Integer value2 : set2) {
                    nowSet.add(value1 + value2);
                    nowSet.add(value1 - value2);
                    nowSet.add(value1 * value2);
                    if (value2 != 0) {
                        nowSet.add(value1 / value2);
                    }
                }
            }

            int operator = 0;
            for (int j = 0; j < depth; j++) {
                operator = operator * 10 + N;
            }

            nowSet.add(operator);
        }

    }
}
