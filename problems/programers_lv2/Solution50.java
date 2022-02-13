package programers_lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution50 {
    public static void main(String[] args) {

        System.out.println(solution("LULLLLLLU"));
    }
    public static int solution(String dirs) {

        Set<String> visited = new HashSet<>();
        int nowX = 5;
        int nowY = 5;
        int count = 0;
        for (char direction : dirs.toCharArray()) {
            switch (direction) {
                case 'L':
                    if (nowY > 0) {
                        nowY--;
                        if (!visited.contains("" + nowX + (nowY + 1) + nowX + nowY)) {
                            visited.add("" + nowX + (nowY + 1) + nowX + nowY);
                            visited.add("" + nowX + nowY + nowX + (nowY + 1));
                            count++;
                        }
                    }
                    break;

                case 'R':
                    if (nowY < 10) {
                        nowY++;
                        if (!visited.contains("" + nowX + (nowY - 1) + nowX + nowY)) {
                            visited.add("" + nowX + (nowY - 1) + nowX + nowY);
                            visited.add("" + nowX + nowY + nowX + (nowY - 1));
                            count++;
                        }
                    }
                    break;

                case 'U':
                    if (nowX < 10) {
                        nowX++;
                        if (!visited.contains("" + (nowX - 1) + nowY + nowX + nowY)) {
                            visited.add("" + (nowX - 1) + nowY + nowX + nowY);
                            visited.add("" + nowX + nowY + (nowX - 1) + nowY);
                            count++;
                        }
                    }
                    break;

                case 'D':
                    if (nowX > 0) {
                        nowX--;
                        if (!visited.contains("" + (nowX + 1) + nowY + nowX + nowY)) {
                            visited.add("" + (nowX + 1) + nowY + nowX + nowY);
                            visited.add("" + nowX + nowY + (nowX + 1) + nowY);
                            count++;
                        }
                    }
                    break;
            }
        }
            return count;
    }
}
