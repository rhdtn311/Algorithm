package programers_lv2;

import java.util.Arrays;

public class Solution62 {

    public int[] solution(int n, long left, long right) {

        int[] arr = new int[(int) (right - left + 1)];
        int index = 0;

        long x = left / n;
        long y = left % n;
        int count = 0;
        while (true) {
            System.out.println("x : " + x + "  y : " + y);
            arr[index++] = (int) Math.max(x, y++) + 1;

            if (count >= right - left) {
                break;
            }
            count++;

            if (y >= n) {
                y = 0;
                x++;
            }
        }
        return arr;
    }
}