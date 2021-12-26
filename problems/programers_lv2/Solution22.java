package programers_lv2;

public class Solution22 {

    static int count = 0;

    public int solution(String name) {

        for (int i = 0; i < name.length(); i++) {
            System.out.println(25 - (name.charAt(i) - 'A'));
            count += Math.min(name.charAt(i) - 'A', 25 - (name.charAt(i) - 'A') + 1);
        }

        int min = name.length() - 1;
        for (int i = 0; i < name.length() - 1; i++) {

            int minCount = i + 1;
            if (name.charAt(i + 1) == 'A') {
                while (minCount < name.length() && name.charAt(minCount) == 'A') {
                    minCount++;
                }
            }

            min = Math.min(min, i + i + name.length() - minCount);
        }

        return count + min;
    }
}
