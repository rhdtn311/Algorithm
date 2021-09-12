package programers_lv1;

public class etc_43 {
    public String solution(String phone_number) {
        String[] array = phone_number.split("");

        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += i < array.length - 4 ? "*" : array[i];
        }

        return result;
    }

    public static void main(String[] args) {

        etc_43 s = new etc_43();
        String solution = s.solution("01033334444");
        System.out.println(solution);
    }
}
