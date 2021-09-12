package programers_lv1;

public class etc_12 {
    // 프로그래머스 lv 1 : 소수 만들기 (https://programmers.co.kr/learn/courses/30/lessons/12977)
    public int solution(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (checkSosu(sum)) count ++;
                }
            }
        }

        return count;
    }

    public boolean checkSosu(int num) {

        for (int i = 2; i<num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        etc_12 s = new etc_12();
        int result = s.solution(new int[]{1, 2, 3, 4});
        System.out.println(result);
    }

}
