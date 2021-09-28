package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2941version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // c=
        //	c-
        //	dz=
        //	d-
        //	lj
        //	nj
        //	s=
        //	z=
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            count++;
            char c = s.charAt(i);
            if (i+1 < s.length()) {
                str = String.valueOf(c) + s.charAt(i + 1);
                if (str.equals("c=") || str.equals("c-") || str.equals("d-") || str.equals("lj")
                || str.equals("nj") || str.equals("s=") || str.equals("z=")) {
                    i = i + 1;
                    continue;
                }
            }
            if (i+2 < s.length()) {
                str = String.valueOf(c) + s.charAt(i + 1) + s.charAt(i + 2);
                if (str.equals("dz=")) {
                    i = i + 2;
                }
            }
        }
        System.out.println(count);
    }
}
