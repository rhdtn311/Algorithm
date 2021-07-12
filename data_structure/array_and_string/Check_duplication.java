package array_and_string;

import java.util.Hashtable;
import java.util.Map;

// 문자열 안에 동일한 문자가 있는지 확인
public class Check_duplication {

    public boolean method1(String str) {
        // 해쉬 테이블을 이용한 방법
        Map<Character, Boolean> hashtable = new Hashtable<>();
        for (int i = 0; i < str.length(); i++) {
            if (hashtable.containsKey(str.charAt(i))) {
                return true;
            }
            hashtable.put(str.charAt(i), true);
        }
        return false;
    }

    public boolean method2(String str) {
        // 자료구조를 이용하지 않는 방법
        boolean[] check = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int word = str.charAt(i);
            if (check[word]) {
                return true;
            }
            check[word] = true;
        }
        return false;
    }
}
