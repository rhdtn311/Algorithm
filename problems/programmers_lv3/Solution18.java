package programmers_lv3;

import java.util.*;

public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        solution18.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
    }

    public int solution(int[] stones, int k) {
        int min = 0;
        int max = 200000000;
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            boolean zeroCount = zeroCount(stones, mid, k);
            if (zeroCount) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }

    boolean zeroCount(int[] stones, int mid, int k) {

        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid < 0) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                return false;
            }
        }

        return true;
    }
}

