package programers_lv1;

import java.util.*;

public class etc_06 {
    // 프로그래머스 level : K번째 수 (https://programmers.co.kr/learn/courses/30/lessons/42748)
    public int[] solution(int[] array, int[][] commands) {

        int[] result = new int[commands.length];
        int index = 0;

        for (int[] arr : commands) {

            int i = arr[0];
            int j = arr[1];
            int k = arr[2];

            ArrayList<Integer> arrayList = new ArrayList<>();

            int count = 0;

            for (int l : array) {
                ++count;
                if (count >= i && count <= j) {
                    arrayList.add(l);
                }
            }

            Collections.sort(arrayList);

            result[index] = arrayList.get(k-1);
            index += 1;

        }
        return result;
    }
}
