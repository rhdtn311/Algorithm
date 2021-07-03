public class etc_19 {
    // 프로그래머스 lv1 : 2016년 (https://programmers.co.kr/learn/courses/30/lessons/12901)
    public String solution(int a, int b) {
        int totalDay = 0;
        if ( a > 1 ) {
            for (int i = 1; i < a; i++) {
                totalDay += monthToDay(i);
            }
        }
        totalDay += b-1;

        String[] day = new String[] {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        return day[totalDay%7];
    }

    public int monthToDay(int month) {
        int sum = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            sum += 31;
        } else if ( month == 2) {
            sum += 29;
        } else {
            sum += 30;
        }

        return sum;
    }

    public static void main(String[] args) {
        etc_19 s = new etc_19();
        String solution = s.solution(5, 24);
        System.out.println(solution);
    }
}