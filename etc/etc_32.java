public class etc_32 {
    // 프로그래머스 lv 1 : 시저 암호 (https://programmers.co.kr/learn/courses/30/lessons/12926)
    public String solution(String s, int n) {

        String result = "";
        char[] chars = s.toCharArray();
        for (char alpha : chars) {
            if (alpha == ' ') {
              result += " ";
            } else if ('a' <= alpha && alpha <= 'z') {
                if (alpha + n <= 'z') {
                    System.out.println(alpha);
                    result = result + Character.toString(alpha + n);
                } else { result = result + Character.toString( 'a' + alpha + n -'z'-1);}
            } else if ('A' <= alpha && alpha <= 'Z') {
                if (alpha + n <= 'Z') {
                    result = result + Character.toString(alpha + n);
                } else {
                    result = result + Character.toString('A' + alpha + n - 'Z' -1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        etc_32 s = new etc_32();
        System.out.println(s.solution("A B C Z", 3));
    }
}
