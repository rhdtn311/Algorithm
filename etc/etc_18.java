import java.util.*;

public class etc_18 {
    // 프로그래머스 lv 1 : 두개 뽑아서 더하기 (https://programmers.co.kr/learn/courses/30/lessons/68644)
    public int[] solution(int[] number) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < number.length-1; i ++) {
            for (int j = i+1 ; j < number.length; j++) {
                set.add(number[i] + number[j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}
