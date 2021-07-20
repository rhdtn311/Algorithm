package stack_and_queue;

import java.util.*;

public class QueueProblem4 {

    // 프로그래머스 lv 2 : 주식 가격 (https://programmers.co.kr/learn/courses/30/lessons/42584)
    public int[] solution(int[] prices) {

        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    result[i] = count;
                    break;
                }
                result[i] = count;
            }
        }
        return result;
    }
}
