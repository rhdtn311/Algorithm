package programers_lv2;

import java.util.*;

public class etc_08 {
    public int[] solution(int rows, int columns, int[][] queries) {

        int value = 1;
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++;
            }
        }

        int[] result = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int min = rotateClockwise(matrix, query);
            result[index] = min;
            index++;
        }


        return result;
    }

    public int rotateClockwise(int[][] matrix, int[] query) {
        int startRow = query[0] - 1;
        int endRow = query[2] -1;
        int startColumn = query[1] -1;
        int endColumn = query[3] - 1;

        int[] moveRow = new int[] {0,1,0,-1};
        int[] moveColumn = new int[] {1,0,-1,0};

        int nowRow = startRow;
        int nowColumn = startColumn;

        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(matrix[startRow + 1][startColumn]);
        for (int i = 0; i < 4;) {

            int nextRow = nowRow +  moveRow[i];
            int nextColumn = nowColumn + moveColumn[i];

            if (nextRow > endRow || nextColumn > endColumn || nextRow < startRow || nextColumn < startColumn) {
                i++;
                continue;
            }
            arrayList.add(matrix[nowRow][nowColumn]);
            queue.add(matrix[nowRow][nowColumn]);
            matrix[nowRow][nowColumn] = queue.poll();

            nowRow = nextRow;
            nowColumn = nextColumn;
        }

        Collections.sort(arrayList);
        return arrayList.get(0);

    }

    public static void main(String[] args) {
        etc_08 s = new etc_08();
        int[] solution = s.solution(6, 6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}});
        int[] solution1 = s.solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
        int[] solution2 = s.solution(100, 97, new int[][]{{1, 1, 100, 97}});
        System.out.println(Arrays.toString(solution2));
    }
}
