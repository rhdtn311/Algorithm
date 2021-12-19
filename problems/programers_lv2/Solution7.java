package programers_lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution7 {

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();

        int total = 0;
        int day = 1;
        int count = 0;
        int index = 0;
        while (total < progresses.length) {

            if (progresses[index] + speeds[index] * day < 100) {

                if (count > 0) {
                    list.add(count);
                    total += count;
                    count = 0;
                }
                day++;

            } else {
                count++;
                if (index == progresses.length - 1) {
                    list.add(count);
                    break;
                }
                index++;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
