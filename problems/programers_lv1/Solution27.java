package programers_lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution27 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        if (result.length == 0) {
            result = new int[]{-1};
            return result;
        }

        Arrays.sort(result);

        return result;
    }
}
