package programers_lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution47 {

    public static int solution(String skill, String[] skill_trees) {

        int count = 0;
        for (String skill_tree : skill_trees) {

            boolean correct = true;
            Queue<Character> queue = new LinkedList<>();
            for (char c : skill.toCharArray()) {
                queue.add(c);
            }

            for (char sk : skill_tree.toCharArray()) {
                if (!queue.contains(sk)) {
                    continue;
                }

                if (queue.peek() == sk) {
                    queue.poll();
                } else {
                    correct = false;
                    break;
                }
            }

            if (correct) {
                count++;
            }
        }

        return count;
    }
}
