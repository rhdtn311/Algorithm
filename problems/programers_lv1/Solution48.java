package programers_lv1;

public class Solution48 {
    public double solution(int[] arr) {

        int sum = 0;
        for (int n : arr) {
            sum += n;
        }

        return (double)sum / arr.length;
    }
}
