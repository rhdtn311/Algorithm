package programers_lv2;

import java.util.Arrays;
import java.util.Comparator;

public class etc_10 {
    // 프로그래머스 lv 2 : 전화번호 목록(https://programmers.co.kr/learn/courses/30/lessons/42577)
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i].length() >= phone_book[i + 1].length()) continue;

            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
