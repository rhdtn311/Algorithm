package programers_lv1;

public class Solution22 {
    public long solution(int price, int money, int count) {

        int n = 1;
        int sum = 0;
        while (count >= 0) {
            count--;

            sum += (price * n++);
        }

        return money - sum > 0 ? 0 : Math.abs(money - sum);
    }
}
