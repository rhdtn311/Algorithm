package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int n1 = Integer.parseInt(input1[i]);
            int n2 = Integer.parseInt(input2[i]);

            if (n1 == n2) System.out.println("D");
            else if (Math.abs(n1 - n2) > 1) {
                if (n1 > n2) System.out.println("B");
                else System.out.println("A");
            } else {
              if (n1 > n2) System.out.println("A");
              else System.out.println("B");
            }
        }
    }
}
