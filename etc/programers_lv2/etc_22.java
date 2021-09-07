package programers_lv2;

import java.util.*;

public class etc_22 {
    // 프로그래머스 lv 2: 위장
    public int solution(String[][] clothes) {

        // [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.putIfAbsent(cloth[1], 0);
            map.computeIfPresent(cloth[1], (k,v) -> v+1);
        }

        int[] values = map.values().stream().mapToInt(Integer::intValue).toArray();
        int result = 1;
        for (int i = 0; i < values.length; i++) {
            result *= (values[i] + 1);
        }

        return result - 1;
    }

//    public static void combination(int r, int[] values) {
//        for (int i = 1; i <  (1 << r) ; i++) {
//            int value = 1;
//            for (int j = 0; j < r; j++) {
//                if ((i & (1 << j)) > 0) {
//                    value *= values[j];
//                }
//            }
//            arrayList.add(value);
//        }
//    }

    public static void main(String[] args) {
        etc_22 s = new etc_22();
        int solution = s.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(solution);

    }
}
