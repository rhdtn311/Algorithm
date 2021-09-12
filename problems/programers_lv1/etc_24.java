package programers_lv1;

import java.util.*;
public class etc_24 {

    public int[] solution(int[] arr, int divisor) {
        // 프로그래머스 lv 1 : 나누어 떨어지는 숫자 배열 (https://programmers.co.kr/learn/courses/30/lessons/12910)
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i%divisor == 0) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            list.add(-1);
        }
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
