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

        int max = result[2];
        ArrayList<Integer> arr = new ArrayList<>();

        int[] originalResult = {oneResult, twoResult, threeResult};
        for (int i = 0; i<3; i++) {
            if (max == originalResult[i]) {
                arr.add(1+i);
            }
        }

        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
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
