package baekjoon;

import java.util.Arrays;

public class Main4673 {
    public static void main(String[] args) {

        boolean[] safeBox = new boolean[10001];
        for (int i = 1; i < 10000; i++) {
            int num = getSafeNumber(i);

            if (num < 10000) {
                safeBox[num] = true;
            }
        }
        System.out.println(Arrays.toString(safeBox));

        StringBuilder s = new StringBuilder();
        for (int i = 1; i < 10000; i++) {
            if (!safeBox[i]) {
                s.append(i).append("\n");
            }
        }
        System.out.println(s);
    }

    public static int getSafeNumber(int n) {

        int sum = n;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}

