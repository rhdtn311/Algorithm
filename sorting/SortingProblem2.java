import java.util.*;

public class SortingProblem2 {
    // 프로그래머스 lv 2 : H - index (https://programmers.co.kr/learn/courses/30/lessons/42747)
    // 계수 정렬을 이용
    public int solution(int[] citations) {
        int[] array = new int[10001];

        int maxValue = 0;
        for (int i = 0; i < citations.length; i++) {
            array[citations[i]]++;
            if (citations[i] > maxValue) maxValue = citations[i];
        }

        int max = 0;
        int index = maxValue ;
        while (true) {
            max += array[index];
            int min = 0;

            for (int i = 0; i < index; i++) {
                min += array[i];
            }

            if (max >= index && min <= index) {
                return index;
            }

            index--;
            if (index < 0) { return 0; }

        }
    }
}
