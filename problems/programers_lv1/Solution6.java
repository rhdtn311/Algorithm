package programers_lv1;

import java.util.Arrays;

public class Solution6 {
    public int solution(int[] numbers) {

        int max = 45;
        for (int i = 0; i < numbers.length; i++) {
            max -= numbers[i];
        }

        return max;
    }

    public int solution2(int[] numbers) {
        int[] arr = new int[10];

        for (int number : numbers) {
            arr[number] = 1;
        }

        int sum = 0;
        for (int i = 1; i < 10; i++) {
            if (arr[i] == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
