package programers_lv1;

public class etc_40 {
    public int solution(int num) {
        int count = 0;
        while (true) {
            if (num == 1) {
                break;
            }
            System.out.println("num : " + num);
            if (count == 500) {
                count = -1;
                break;
            } else {
                if (num % 2 == 0) {
                    num /= 2;
                    count ++;
                } else {
                    num = (num * 3) + 1;
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        etc_40 s = new etc_40();
        int solution = s.solution(1);
        System.out.println(solution);
    }
}
