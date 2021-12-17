package programers_lv2;

public class Solution5 {
    public long solution(int w, int h) {

        int gcd = gcd(w, h);

        return (long) w * h - (w + h - gcd);
    }

    int gcd(int w, int h) {

        int n1 = Math.max(w, h);
        int n2 = Math.min(w, h);
        while (n2 != 0) {

            int r = n1 % n2;
            n1 = n2;
            n2 = r;
        }

        return n1;
    }
}
