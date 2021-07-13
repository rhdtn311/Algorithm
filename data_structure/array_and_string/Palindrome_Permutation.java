package array_and_string;
import java.util.*;

// 주어진 문자열이 회문 순열인지 아닌지 확인
public class Palindrome_Permutation {

    // O(N)
    public boolean method1(String str) {

        Map<Character, Integer> wordAmount = new Hashtable<>();
        String lowerStr = str.toLowerCase();
        for (int i = 0; i < lowerStr.length(); i++) {
            char c = lowerStr.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (wordAmount.containsKey(c)) {
                Integer value = wordAmount.get(c);
                wordAmount.put(c, ++value);
            } else {
                wordAmount.put(c, 1);
            }
        }

        Collection<Integer> values = wordAmount.values();
        int oddCount = 0;
        for (int i : values) {
            if (i % 2 == 1) {
                oddCount++;
            }
            if (oddCount > 1) { return false; }
        }

        return true;
    }
}
