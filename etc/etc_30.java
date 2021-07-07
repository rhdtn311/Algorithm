import java.util.*;

public class etc_30 {
    // 프로그래머스 lv1 : 소수 찾기 (https://programmers.co.kr/learn/courses/30/lessons/12921)
    public int solution(int n) {

        boolean[] values = new boolean[n+1];
        int count = 0;
        int plusNum = 0;

        for (int i = 2 ; i < Math.sqrt(n); i++) {
            if (values[i]) {
                continue;
            }

            plusNum = i+i;

            while(plusNum < n+1) {
                if (!values[plusNum]) {
                    values[plusNum] = true;
                    count++;
                }
                plusNum += i;
            }
        }

        System.out.println(Arrays.toString(values));
        System.out.println(n-1-count);
        return n-1-count;
    }

    public static void main(String[] args) {
        etc_30 s = new etc_30();
        s.solution(5);
        System.out.println(Math.sqrt(10));
    }
}
