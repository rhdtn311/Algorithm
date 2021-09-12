package programers_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class etc_24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : array) {
            if (i < x) {
                result.add(i);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (i == result.size()-1) {
                System.out.print(result.get(i));
                break;
            }
            System.out.print(result.get(i) + " ");
        }
    }
}
