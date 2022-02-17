package programers_lv2;

import java.util.Arrays;

public class Solution55 {

    public int solution(int n, int k) {
        String s = Integer.toString(n, k);

        int count = 0;
        String[] arr = s.split("0");
        for (int i = 0; i < arr.length; i++) {

            long num = 0;
            try {
                num = Long.parseLong(arr[i]);
            } catch(Exception e) {
                continue;
            }

            if (checkPrime(num)) {
                count++;
            }
        }

        return count;
    }

    public boolean checkPrime(long n) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
