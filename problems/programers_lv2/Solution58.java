package programers_lv2;

public class Solution58 {
    public int solution(int n) {
        int nCount = Integer.bitCount(n);

        int next = n + 1;
        while (true) {
            if (nCount == Integer.bitCount(next)) {
                return next;
            }
            next++;
        }
    }
}
