package programers_lv1;

import java.util.Arrays;

public class Solution11 {
    public int[] solution(int[] array, int[][] commands) {

        int index = 0;
        int[] resultArray = new int[commands.length];
        for (int[] command : commands) {
            int[] newArr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(newArr);

            resultArray[index++] = newArr[command[2]-1];
        }

        return resultArray;
    }
}
