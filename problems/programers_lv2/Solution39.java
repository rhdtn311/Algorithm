package programers_lv2;

import java.util.*;

public class Solution39 {
    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty() || prices[stack.peek()] <= prices[i]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            result[index] = result.length - index -1;
        }

        return result;
    }
}
