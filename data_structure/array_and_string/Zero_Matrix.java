package array_and_string;

import java.util.*;

// M X N 행렬의 한 원소가 0일 때, 그 원소가 속한 행과 열의 모든 원소를 0으로 변경
public class Zero_Matrix {

    public int[][] method1(int[][] matrix) {

        int column = matrix.length;
        int row = matrix[0].length;

        List<Integer> columns = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        // O(MN)
        for (int i = 0; i < column; i++) {

            for (int j = 0; j < row; j++) {

                if (matrix[i][j] == 0) {
                    columns.add(i);
                    rows.add(j);
                }
            }
        }

        for (int col : columns) {
            for (int j = 0; j < row; j++) {
                matrix[col][j] = 0;
            }
        }

        for (int r : rows) {
            for (int j = 0; j < column; j++) {
                matrix[j][r] = 0;
            }
        }

        return matrix;
    }
}
