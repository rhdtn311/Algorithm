package programers_lv2;

public class Solution32 {
    public int[] solution(int brown, int yellow) {

        int result[] = new int[2];
        while (true) {

            for (int i = 3; i <= 5000; i++) {
                for (int j = 3; j <= 5000; j++) {
                    int area = i * j;
                    int B = i * 2 + (j - 2) * 2;
                    int Y = area - B;

                    if (B == brown && Y == yellow) {
                        result[0] = j;
                        result[1] = i;
                        return result;
                    }
                }
            }
        }
    }
}
