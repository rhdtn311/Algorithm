package programers_lv2;

public class etc_19 {
    // 프로그래머스 lv 2 : 예상 대진표
    public int solution(int n, int a, int b) {

        int count = 0;
        while(true) {
            count++;

            int max = Math.max(a, b);
            int min = Math.min(a, b);

            if (max % 2 == 0) {
                if (max - 1 == min) {
                    return count;
                }
            }

            if (a % 2 == 1) {
                a =  a / 2 + 1;
            } else {
                a = a / 2;
            }

            if (b % 2 == 1) {
                b = b / 2 + 1;
            } else {
                b = b / 2;
            }
        }
    }
}
