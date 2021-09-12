package programers_lv1;

import java.util.*;
public class etc_23 {
    // 프로그래머스 lv 1 : 같은 숫자는 싫어
    public int[] solution(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        int keep = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != keep) {
                keep = arr[i];
                result.add(keep);
            } else {
                continue;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
