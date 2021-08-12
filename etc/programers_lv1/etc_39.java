package programers_lv1;

import java.util.Arrays;

public class etc_39 {
    // 프로그래머스 lv 1 : 제일 작은 수 제거하기 (https://programmers.co.kr/learn/courses/30/lessons/12935)
    public int[] solution(int[] arr) {
        int[] result = new int[arr.length-1];
        if (arr.length != 1) {
            int minValue = Arrays.stream(arr).min().getAsInt();
            result = Arrays.stream(arr).filter(i -> i != minValue).toArray();
        } else {
            result = new int[] {-1};
        }
        return result;
    }
}
