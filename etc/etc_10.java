import java.util.*;

public class etc_10 {
    // 프로그래머스 level 1 : 모의고사 (https://programmers.co.kr/learn/courses/30/lessons/42840)
    public int[] solution(int[] answers) {

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int oneResult = checkScore(answers, one);
        int twoResult = checkScore(answers, two);
        int threeResult = checkScore(answers, three);

        int[] result = {oneResult, twoResult, threeResult};
        Arrays.sort(result);

        int[] answer;
        if (result[2] == result[0]) {
            return new int[] {1,2,3};
        } else if (result[2] == result[1]) {
            answer = new int[] {result[1], result[2]};
        } else {
            answer = new int[] {result[2]};
        }

        int studentIndex = 0;
        boolean checkOne = false;
        boolean checkTwo = false;
        boolean checkThree =false;
        for (int i : answer) {
            if (i == oneResult && checkOne == false) {
                answer[studentIndex] = 1;
                checkOne = true;
            } else if (i == twoResult && checkTwo == false) {
                answer[studentIndex] = 2;
                checkTwo = true;
            } else if (i == threeResult && checkThree == false){
                answer[studentIndex] = 3;
                checkThree = true;
            }
            studentIndex++;
        }

        return answer;
    }

    public int checkScore(int[] answers, int[] student) {

        int studentIndex = 0;
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (student[studentIndex] == answers[i]) {
                score++;
            }
            studentIndex++;

            if(studentIndex > student.length-1) {
                studentIndex = 0;
            }
        }
        return score;
    }
}
