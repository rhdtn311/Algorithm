package tree_graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Problem3 {
    // 프로그래머스 lv 2 : 타겟 넘버 (https://programmers.co.kr/learn/courses/30/lessons/43165)

    public int dfs(int result, int index, int[] numbers, int target) {

        if (index > numbers.length - 1) {
            if (target == result) {
                return 1;
            }
            return 0;
        }

        int plusResult = result + numbers[index];
        int minusResult = result - numbers[index];

        int value = 0;
        value += dfs(plusResult, index + 1, numbers, target);
        value += dfs(minusResult, index + 1, numbers, target);

        return value;
    }



    public int solution(int[] numbers, int target) {
        int result1 = dfs(numbers[0], 1, numbers, target);
        int result2 = dfs(-numbers[0],1, numbers, target);

        return result1 + result2;

    }


    public static void main(String[] args) {

    }
}
