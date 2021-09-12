package programers_lv2;

class etc_07 {
    // 프로그래머스 lv 2 : 문자열 압축 (https://programmers.co.kr/learn/courses/30/lessons/60057)
    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int answer = s.length();
        // i만큼 압축한다. compression에 매개변수로 보낸다.
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, compression(s, i));
        }
        return answer;
    }

    // 문자열을 압축
    public int compression(String s, int i) {
        StringBuilder resultWord = new StringBuilder();

        int hit = 1;    // 압축 가능한 문자열을 발견했다면 hit를 1씩 올린다.
        String standardWord = "";   // 기준이 되는 문자열

        // j : 비교 문자열의 시작점
        for (int j = 0; j <= s.length(); j += i) {
            System.out.println(j);
            String compareWord;

            // 비교 문자열의 끝점(substring의 endIndex 부분) s의 크기를 넘어간다면
            // 앞의 기준이 되는 문자열과 길이가 달라 항상 다르므로 (짜투리 문자열)
            // 결과 문자열 가장 끝에 붙여주기만한다.
            if (j + i > s.length()) {
                compareWord = s.substring(j);
                resultWord.append(compareWord);
            } else {
                // 비교문자열 = 전체 문자열의 j부터 i만큼 까지
                compareWord = s.substring(j, j + i);
            }

            // 기준 문자열이 비교 문자열과 같다면 hit++
            if (standardWord.equals(compareWord)) {
                hit++;

            } else {
                if (hit > 1) {
                    // 기준 문자열이 비교 문자열과 다르고 이미 앞 비교문자열과 같은 적이 있다면
                    resultWord.append(hit + standardWord);
                } else {
                    // 기준 문자열이 비교 문자열과 다르고 앞 비교문자열과도 달랐다면
                    resultWord.append(standardWord);
                }
                hit = 1;
            }
            // 기준 문자열 = 비교 문자열로 바꿔준다.
            standardWord = compareWord;
        }
        return resultWord.length();
    }

    public static void main(String[] args) {
        etc_07 s= new etc_07();
        int abcabcdede = s.solution("abcabcdede");
    }
}