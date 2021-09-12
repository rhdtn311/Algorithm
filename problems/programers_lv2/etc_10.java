package programers_lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

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

    // n = phone_nook.length (최대 1000000), m = 전화번호 길이 (최대 20)
    public boolean solution2(String[] phone_book) {

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));     // O(n)

        System.out.println(set);
        for (int i = 0; i < phone_book.length; i++) {   // O(n)
            for (int j = 0; j < phone_book[i].length(); j++) {  // O(n * m) -> m은 상수
                if (set.contains(phone_book[i].substring(0,j))) {   // contains : O(1), substring : O(m) m은 j
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution3(String[] phone_book){
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = 0; j < phone_book.length; j++) {

                if (i == j) continue;

                if (phone_book[i].startsWith(phone_book[j]) || phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
