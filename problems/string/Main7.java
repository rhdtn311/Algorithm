package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();

        String answer = "YES";

        int lt = 0;
        int rt = input.length() - 1;
        while (lt < rt) {
            if (input.charAt(lt) != input.charAt(rt)) {
                answer = "NO"; break;
            }
            lt++;
            rt--;
        }
        System.out.println(answer);
    }
}
