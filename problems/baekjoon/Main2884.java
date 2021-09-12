package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2884 {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int hour = Integer.parseInt(s[0]);
    int minute = Integer.parseInt(s[1]);

    int newMinute = minute - 45;
    if (newMinute < 0) {
        if (hour > 0) {
            hour -= 1;
        } else {
            hour = 23;
        }
        newMinute = 60 + newMinute;
    }

    System.out.println(hour + " " + newMinute);
}
}
