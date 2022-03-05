package programmers_lv3;

public class Solution4 {

    static int min = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        dfs(0, N, number, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // depth : 현재 연산식 중 N이 몇 번 사용됐는지
    // sum : 현재 연산식의 결과 값
    public void dfs(int depth, int N, int number, int sum) {

        if (depth > 8) {
            return;
        }

        if (sum == number) {
            min = Math.min(min, depth);
        }

        int value = 0;
        for (int i = 1; i <= 8; i++) {
            value = value * 10 + N;
            if (depth + i <= 8) {
                dfs(depth + i, N, number, sum + value);
                dfs(depth + i, N, number, sum - value);
                dfs(depth + i, N, number, sum * value);
                dfs(depth + i, N, number, sum / value);
            }
        }
    }
}
