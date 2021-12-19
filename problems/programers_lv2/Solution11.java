package programers_lv2;

public class Solution11 {

    public static int[] solution(int rows, int columns, int[][] queries) {

        int[][] graph = new int[rows][columns];

        int[] result = new int[queries.length];
        int index = 0;

        int v = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                graph[i][j] = v++;
            }
        }

        for (int[] query : queries) {
            int lc = query[0] - 1;
            int lr = query[1] - 1;
            int rc = query[2] - 1;
            int rr = query[3] - 1;

            int value = graph[lc][lr];
            int column = lc;
            int row = lr;
            int min = value;

            while (true) {

                if (column == lc && row < rr) {
                    int temp = graph[column][row + 1];
                    graph[column][row + 1] = value;
                    value = temp;
                    row++;
                } else if (row == rr && column < rc) {
                    int temp = graph[column + 1][row];
                    graph[column + 1][row] = value;
                    value = temp;
                    column++;
                } else if (column == rc && row > lr) {
                    int temp = graph[column][row - 1];
                    graph[column][row - 1] = value;
                    value = temp;
                    row--;
                } else {
                    int temp = graph[column - 1][row];
                    graph[column - 1][row] = value;
                    value = temp;
                    column--;
                }

                min = Math.min(value, min);

                if (column == lc && row == lr) {
                    break;
                }
            }

            result[index++] = min;
        }

        return result;
    }
}
