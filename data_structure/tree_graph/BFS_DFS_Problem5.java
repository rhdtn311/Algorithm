package tree_graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Problem5 {
    // 프로그래머스 lv 3 : 단어 변환 (https://programmers.co.kr/learn/courses/30/lessons/43163)
    public int solution(String begin, String target, String[] words) {

        // target 단어가 words 에 없다면 0을 리턴
        boolean checkNotAnswer = false;
        for (String word : words) {
            if (word.equals(target)) {
                checkNotAnswer = true;
            }
        }
        if (!checkNotAnswer) return 0;

        // queue에 begin 단어와 한 글자만 다른 초기 단어를 삽입
        Queue<Word> queue = new LinkedList<>();
        for (String word : words) {
            if (checkDifference(begin, word)) {
                Word newWord = new Word(word, 1);
                queue.add(newWord);
            }
        }

        // 큐에서 단어를 하나씩 꺼내면서 그 단어와 하나만 다른 단어를 탐색해가며 target 단어를 찾음
        while (!queue.isEmpty()) {
            Word nowWord = queue.poll();

            if(nowWord.name.equals(target)) {
                return nowWord.count;
            }

            for (String word : words) {
                if (checkDifference(word, nowWord.name)) {
                    Word newWord = new Word(word, nowWord.count + 1);
                    queue.add(newWord);
                }
            }
        }

        return 0;
    }

    // 한 단어가 다른 단어와 한 글자 이상 다르다면 false, 한 글자만 다르다면 true 를 리턴
    public boolean checkDifference(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diffCount++;
        }

        if (diffCount == 1) {
            return true;
        } else {
            return false;
        }
    }

    // 단어와 깊이를 저장하는 객체를 생성하기 위한 클래스
    public class Word {
        private String name;
        private int count;

        public Word(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
