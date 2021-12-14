package programers_lv1;

public class Solution49 {
    public boolean solution(int x) {

        int save = x;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return save % sum == 0;
    }
}
