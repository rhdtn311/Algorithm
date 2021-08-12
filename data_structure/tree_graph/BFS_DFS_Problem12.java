package tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_DFS_Problem12 {
    // 백준 1987 알파벳 (시간초과)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] board = new String[r][c];

        for (int i = 0; i < r; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                board[i][j] = strings[j];
            }
        }
        Stack<String> stack = new Stack<>();
        int result = dfs(0, 0, board, stack, 0);
        System.out.println(result);
    }

    public static int dfs(int height, int width, String[][] board, Stack<String> stack, int stackSize) {

        int[] moveHeight = new int[] {-1, 1, 0, 0};
        int[] moveWidth = new int[] {0, 0, -1, 1};

        stack.push(board[height][width]);

        stackSize = Math.max(stack.size(), stackSize);
        for (int i = 0; i < 4; i++) {
            int nextHeight = height + moveHeight[i];
            int nextWidth = width + moveWidth[i];

            if (nextWidth < 0 || nextHeight < 0 || nextWidth > board[0].length - 1 || nextHeight > board.length - 1) {
                continue;
            }

            // 중복 검사
            if (stack.contains(board[nextHeight][nextWidth])) continue;

            stackSize = dfs(nextHeight, nextWidth, board, stack, stackSize);
        }

        stack.pop();
        return stackSize;
    }
}
