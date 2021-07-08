public class etc_35 {
    // 프로그래머스 lv 1 : 자릿수 더하기 (https://programmers.co.kr/learn/courses/30/lessons/12931)
    public int solution(int n) {
        String s = String.valueOf(n);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }

        return sum;
    }
}
