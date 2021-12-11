package programers_lv1;

public class Solution40 {

    public int solution(int n) {

        int sum = 0;
        int div = 100000000;
        while (div > 0) {
            sum += n / div;
            n %= div;
            div /= 10;
        }


        return sum;
    }
}
