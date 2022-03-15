package programmers_lv3;

import java.util.*;

public class Solution19 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for (String operation : operations) {
            String[] input = operation.split(" ");

            switch (input[0]) {
                case "I" :
                    maxPq.offer(Integer.parseInt(input[1]));
                    minPq.offer(Integer.parseInt(input[1]));
                    break;

                case "D":
                    if (input[1].equals("1")) {
                        if (!maxPq.isEmpty()) {
                            Integer max = maxPq.poll();
                            minPq.remove(max);
                        }
                    } else {
                        if (!minPq.isEmpty()) {
                            Integer min = minPq.poll();
                            maxPq.remove(min);
                        }
                    }
            }
        }

        int[] result = new int[2];
        result[0] = maxPq.isEmpty() ? 0 : maxPq.peek();
        result[1] = minPq.isEmpty() ? 0 : minPq.peek();

        return result;
    }
}
