import java.util.Arrays;

public class etc_11 {
    public int solution(int[] nums) {

        // 프로그래머스 lv 1: 폰켓몬 (https://programmers.co.kr/learn/courses/30/lessons/1845)

        int result = 1;
        int maxResult = nums.length/2;

        Arrays.sort(nums);
        int checkDifference = nums[0];
        for (int i : nums) {
            if (result == maxResult) {
                break;
            }
            if(checkDifference != i) {
                result += 1;
                checkDifference = i;
            }
        }

        return result;
    }
}
