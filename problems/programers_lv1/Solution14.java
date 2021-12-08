package programers_lv1;

import java.util.HashSet;
import java.util.Set;

public class Solution14 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(nums.length / 2, set.size());
    }
}
