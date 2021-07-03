public class etc_15 {
    // 프로그래머스 lv 1 : 삼진법 뒤집기 ( https://programmers.co.kr/learn/courses/30/lessons/68935)
    public int solution(int n) {

        String str = "" ;

        while (n >0) {
            str = str + (n % 3);
            n /= 3;
        }

        int answer = 0;
        for (int i = 0; i < str.length() ; i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            answer += Math.pow(3,str.length()-(i+1))*num;
        }

        return answer;
    }

    public static void main(String[] args) {

        etc_15 s = new etc_15();
    s.solution(45);

    }
}
