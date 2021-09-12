package programers_lv1;

public class etc_42 {
    public boolean solution(int x) {
        int sum = 0;
        String str = String.valueOf(x);

        for (int i = 0; i < str.length(); i++)  {
            sum += Character.getNumericValue(str.charAt(i));
        }
        return x % sum == 0;
    }


    public static void main(String[] args) {
        etc_42 s = new etc_42();
        boolean solution = s.solution(1000);
        System.out.println(solution);
        boolean result = true;
    }
}
