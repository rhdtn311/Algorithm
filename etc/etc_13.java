import java.util.*;
public class etc_13 {
    // 프로그래머스 lv 1 : 크레인 인형뽑기 게임 ( https://programmers.co.kr/learn/courses/30/lessons/64061)
    public int solution(int[][] board, int[] moves) {

        int[] dolls = new int[board.length+1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    dolls[j + 1]++;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i : moves) {
            if (dolls[i] != 0) {
                int doll = board[board.length-dolls[i]][i-1];
                board[board.length-dolls[i]][i-1] = 0;
                dolls[i]--;
                if(stack.isEmpty()) {
                    stack.add(doll);
                    continue;
                }
                if (doll == stack.peek()) {
                    count += 2;
                    stack.pop();
                } else {
                    stack.add(doll);
                }
            }
        }
        return count;
    }
}
