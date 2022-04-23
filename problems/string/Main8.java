package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String answer = "YES";

        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            while (!Character.isAlphabetic(str.charAt(lt))) lt++;
            while (!Character.isAlphabetic(str.charAt(rt))) rt--;

            char c1 = Character.toLowerCase(str.charAt(lt));
            char c2 = Character.toLowerCase(str.charAt(rt));

            if (c1 != c2) {
                answer = "NO";
                break;
            }

            lt++;
            rt--;
        }

        System.out.println(answer);
    }
}
