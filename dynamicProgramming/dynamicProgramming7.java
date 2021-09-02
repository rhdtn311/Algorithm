import java.util.Arrays;

public class dynamicProgramming7 {
    public static int solution(int n, int[] food) {
        // food = {1,3,1,5,2,3,4,3,10}

        int[] dp = new int[100];

        dp[0] = food[0];
        dp[1] = Math.max(food[0], food[1]);
        for (int i = 2; i < food.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + food[i]);
        }

        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int solution = solution(9, new int[]{100, 3, 1, 5,2,3,4,3,8});
        System.out.println(solution);
    }
}
