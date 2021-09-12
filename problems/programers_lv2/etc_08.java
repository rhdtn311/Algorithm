package programers_lv2;

import java.util.*;

public class etc_08 {
    public int[] solution(int rows, int columns, int[][] queries) {

        // 행렬만들기
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

    // 행렬을 시계방향으로 회전
    public int rotateClockwise(int[][] matrix, int[] query) {
        // 인덱스에 맞게 -1
        int startRow = query[0] - 1;
        int endRow = query[2] -1;
        int startColumn = query[1] -1;
        int endColumn = query[3] - 1;

        // 행과 열을 1씩 움직이기 위한 배열
        int[] moveRow = new int[] {0,1,0,-1};
        int[] moveColumn = new int[] {1,0,-1,0};

        // 왼쪽 위 부터 회전
        int nowRow = startRow;
        int nowColumn = startColumn;

        // 모든 테두리 값을 저장할 list
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 이 전 값을 저장할 큐
        Queue<Integer> queue = new LinkedList<>();
        // 큐에 테두리의 가장 마지막 값을 삽입해 놓음
        queue.add(matrix[startRow + 1][startColumn]);
        // 반복문은 가장 오른쪽 부터 반복적으로 돌다가 테두리 밖으로 나갈 때 방향을 시계방향으로 바꾼다.
        for (int i = 0; i < 4;) {

            int nextRow = nowRow +  moveRow[i];
            int nextColumn = nowColumn + moveColumn[i];

            // 다음 위치가 테두리를 넘어간다면 방향을 시계방향으로 회전하고(i++) continue
            if (nextRow > endRow || nextColumn > endColumn || nextRow < startRow || nextColumn < startColumn) {
                i++;
                continue;
            }
            // arrayList에 현재 값을 넣음
            arrayList.add(matrix[nowRow][nowColumn]);
            // queue에 현재 값을 넣음
            queue.add(matrix[nowRow][nowColumn]);
            // 행렬의 현재 위치를 queue에 넣은 값으로 바꿈
            matrix[nowRow][nowColumn] = queue.poll();

            // 현재 위치를 다음 위치로 변경
            nowRow = nextRow;
            nowColumn = nextColumn;
        }

        // 정렬 후 가장 첫번째 값 (최솟값) 리턴
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
