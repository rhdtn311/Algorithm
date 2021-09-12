package programers_lv2;

public class etc_04 {
    // 프로그래머스 lv 2 : 123 나라의 숫자 (https://programmers.co.kr/learn/courses/30/lessons/12899)
    public String solution(int n) {

        StringBuilder s = new StringBuilder();

        while (n > 0) {

            int remain = n % 3;

            switch (remain) {
                case 0 : s.append(4); break;
                case 1 : s.append(1); break;
                case 2 : s.append(2); break;
            }

            if (n % 3 == 0) {
                n = n / 3 - 1;
            } else {
                n = n / 3;
            }
        }

        return s.reverse().toString();
    }
}
