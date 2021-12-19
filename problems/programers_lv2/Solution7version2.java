package programers_lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution7version2 {
    public static void main(String[] args) {
        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }
    public static int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();
        for (int i = progresses.length - 1; i >= 0; i--) {

            stack.push((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
        }

        List<Integer> list = new ArrayList<>();
        int count = 1;
        int now = stack.pop();
        while (!stack.isEmpty()) {

            int next = stack.pop();
            if (next <= now) {
                count++;
            } else {
                now = next;
                list.add(count);
                count = 1;
            }

            if (stack.isEmpty()) {
                list.add(count);
                break;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
