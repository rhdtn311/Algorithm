package programers_lv1;

import java.util.Stack;

public class Solution26 {
    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (stack.peek() != num) {
                    stack.push(num);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
