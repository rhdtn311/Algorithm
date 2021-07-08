public class etc_34 {
    // 프로그래머스 lv 1 : 이상한 문자열 만들기 (https://programmers.co.kr/learn/courses/30/lessons/12930)
    public String solution(String s) {

        String result = "";

        int index = 0;
        for (int i =0; i<s.length(); i++) {
            System.out.println("i : " + i + " index : " + index);
            if (s.charAt(i) == ' ') {
                result += " ";
                index = 0;
                continue;
            }

            if (s.charAt(i) != ' ') {
                if (index % 2 == 0) {
                    result += String.valueOf(s.charAt(i)).toUpperCase();
                } else {
                    result += String.valueOf(s.charAt(i)).toLowerCase();
                }
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {

        etc_34 s= new etc_34();
        String try_hello_world = s.solution("I LIKE YOU   ");
        System.out.println(try_hello_world);
    }
}
