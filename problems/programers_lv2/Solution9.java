package programers_lv2;

public class Solution9 {

    public int solution(int[] numbers, int target) {

        return dfs(numbers, 0, target, 0);
    }

    public int dfs(int[] numbers, int depth, int target, int sum) {

        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(numbers, depth + 1, target, sum + numbers[depth]) +
                dfs(numbers, depth + 1, target, sum - numbers[depth]);
    }
}
