package baekjoon;

public class Main4673 {

    public static void main(String[] args) {
        boolean[] having = new boolean[10000];

        for (int i = 1; i < 10000; i++) {
            int num = i;
            int sum = i;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum < 10000) {
                having[sum] = true;
            }
        }

        for (int i = 1; i < 10000; i++) {
            if (!having[i]) {
                System.out.println(i);
            }
        }
    }
}

