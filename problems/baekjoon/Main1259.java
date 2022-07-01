package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) break;

            String answer = "yes";
            int lt = 0;
            int rt = str.length() - 1;
            while (lt <= rt) {
                if (str.charAt(lt++) != str.charAt(rt--)) {
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);
        }
    }

}
