package programers_lv2;

import java.util.Arrays;

public class Solution40 {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;
        int min = 0;
        for (int i = people.length - 1; min <= i; i--) {
            count++;
            if (people[min] + people[i] <= limit) {
                min++;
            }
        }
        return count;
    }
}
