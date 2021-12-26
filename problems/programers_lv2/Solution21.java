package programers_lv2;

import java.util.HashSet;
import java.util.Set;

public class Solution21 {

    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {

        String[] arr = numbers.split("");
        combination(arr, new boolean[arr.length], 0, new StringBuilder());

        return set.size();
    }

    public void combination(String[] arr, boolean[] visited, int depth, StringBuilder sb) {

        if (sb.length() > 0) {
            if (checkPrime(Integer.parseInt(sb.toString()))) {
                set.add(Integer.parseInt(sb.toString()));
            }
        }

        if (depth == arr.length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, depth + 1, sb.append(arr[i]));
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public boolean checkPrime(int num) {

        if (num == 1 || num == 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
