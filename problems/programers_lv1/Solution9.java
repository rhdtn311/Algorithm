package programers_lv1;

public class Solution9 {

    static int result = 0;

    public static int solution(int[] nums) {

        combination(nums, 0, 0, 0);

        return result;
    }

    static void combination(int[] nums, int sum,int depth, int start) {

        if (depth == 3) {
            result += checkPrimeNum(sum);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            combination(nums, sum + nums[i], depth + 1, i + 1);
        }

        return;
    }

    static int checkPrimeNum(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}
