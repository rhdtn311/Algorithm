package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String answer = "";

        str = str.replace("#", "1").replace("*", "0");
        int slice = 0;
        for (int i = 0; i < n; i++) {
            answer += (char)Integer.parseInt(str.substring(slice, slice + 7), 2);

            slice += 7;
        }

        System.out.println(answer);
    }
}
