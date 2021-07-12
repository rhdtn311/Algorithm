package array_and_string;

import java.util.*;

// 문자열 두 개가 서로 순열 관계에 있는지 확인 (같은 문자 집합들의 배열만 다른 경우)
public class Permutation_Check {

    public boolean method1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        // 두 문자열을 배열한 뒤 같으면 순열관계에 있다.
        return sort(str1).equals(sort(str2));
    }

    public String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean method2(String str1, String str2) {
        // 문자열의 갯수를 센다.

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] checkAmountChar = new char[128];
        for (int i = 0; i < str1.length(); i++) {
            int word = str1.charAt(i);
            checkAmountChar[word]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int word = str2.charAt(i);
            checkAmountChar[word]--;
            if (checkAmountChar[word] < 0) {
                return false;
            }
        }
        return true;
    }
}
