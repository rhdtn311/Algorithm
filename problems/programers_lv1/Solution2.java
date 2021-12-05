package programers_lv1;

public class Solution2 {
    public int[] solution(int[] lottos, int[] win_nums) {

        int count = 0;
        int zeroCount = 0;
        for (int lotto : lottos) {

            if (lotto == 0) {
                zeroCount++;
                continue;
            }

            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    count++;
                    break;
                }
            }
        }

        int[] result = new int[2];
        result[0] = Math.min(7 - count - zeroCount, 6);
        result[1] = Math.min(7 - count, 6);

        return result;
    }
}
