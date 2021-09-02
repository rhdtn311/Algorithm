import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dynamicProgramming9 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            triangle[i] = ints;
        }
        System.out.println(Arrays.deepToString(triangle));

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                } else {
                    triangle[i][j] = Math.max(triangle[i-1][j-1] + triangle[i][j] ,triangle[i-1][j] + triangle[i][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (triangle[n - 1][i] > max) {
                max = triangle[n - 1][i];
            }
        }

        System.out.println(Arrays.deepToString(triangle));
        System.out.println(max);

    }
}
