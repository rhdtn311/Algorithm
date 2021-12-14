package programers_lv1;

public class Solution46 {
    public int[] solution(int n, int m) {

        int gcd = gcd(n, m);

        return new int[]{gcd, (n / gcd) * (m / gcd) * gcd};

    }

    int gcd(int n1, int n2) {

        while (n2 != 0) {
            int d = n1 % n2;

            n1 = n2;
            n2 = d;
        }

        return n1;
    }
}
