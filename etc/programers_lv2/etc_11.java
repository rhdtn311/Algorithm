package programers_lv2;

public class etc_11 {
    // 프로그래머스 lv 2 : 괄호 변환 (https://programmers.co.kr/learn/courses/30/lessons/60058)
    public String solution(String p) {
        // 예외 처리
        if (p.equals("")) return "";
        if (checkCorrect(p)) return p;

        StringBuilder result = new StringBuilder();

        return conversionBrackets(p, result);
    }

    // 괄호 변환 메서드
    public String conversionBrackets (String s, StringBuilder answer) {

        // s가 빈 문자열이라면 빈 문자열을 return
        if (s.equals("")) {
            return "";
        }

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        // u와 v의 경계가 되는 인덱스
        int separationIndex = separationString(s);

        // 경계 인덱스를 기준으로 u와 v를 나눔
        u.append(s, 0, separationIndex + 1);
        v.append(s, separationIndex + 1, s.length());

        // u가 "올바른 괄호 문자열" 이라면 정답 문자열에 u를 붙이고 v를 다시 처음부터 계산하여 u에 붙힘
        if (checkCorrect(u.toString())) {
            answer.append(u);
            answer.append(conversionBrackets(v.toString(), new StringBuilder()));
        } else {
        // u가 "올바른 괄호 문자열"이 아니라면 "(" + v를 처음부터 계산 + ")" + u의 첫 번째와 마지막을 제거하고 뒤집음
            answer.append("(");
            answer.append(conversionBrackets(v.toString(), new StringBuilder()));
            answer.append(")");
            answer.append(reverseBrackets(u.substring(1, u.length() -1)));
        }

        // 만든 문자열을 반환
        return answer.toString();
    }

    // u, v의 경계를 나누는 함수
    public int separationString(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i));
            if (checkBalance(result.toString())) {
                return i;
            }
        }
        return result.length()-1;
    }

    // 문자열의 해당 문자가 (면 )를, )면 (로 바꾸는 함수
    public String reverseBrackets(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                result.append(")");
            } else {
                result.append("(");
            }
        }

        return result.toString();
    }

    // 문자열의 (, ) 갯수의 군형이 맞는지 확인
    public boolean checkBalance(String s) {
        if (s.length() == 0) {
            return true;
        }

        char[] brackets = s.toCharArray();

        int balance = 0;
        for (char bracket : brackets) {
            if (bracket == '(')  balance++;
            else balance--;
        }

        if (balance == 0) return true;

        return false;
    }

    // "올바른 괄호 문자열" 인지 확인
    public boolean checkCorrect(String s) {
        if (s.length() < 1) {
            return true;
        }

        char[] brackets = s.toCharArray();

        int correct = 0;
        for (char bracket : brackets) {
            if (bracket == '(') correct++;
            else correct--;

            if (correct < 0) return false;
        }
        if (correct == 0) return true;
        return false;
    }
}
