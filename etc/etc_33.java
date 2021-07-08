public class etc_33 {
    // 프로그래머스 lv1 : 약수의 합 ()
    public int solution(int n) {
        int sum =0;
        for (int i = 1; i <= n; i++) {
            sum += n % i == 0 ? i : 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        etc_33 s = new etc_33();
        int solution = s.solution(36);
        System.out.println(solution);
    }
}
