package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Size> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Size size = new Size(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            arrayList.add(size);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            Size now = arrayList.get(i);
            int count = 1;
            for (int j = 0; j < arrayList.size(); j++) {
                if (i == j) continue;
                Size compare = arrayList.get(j);
                if (now.compareTo(compare) == 1) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }

    public static class Size implements Comparable {
        int weight;
        int height;

        public Size(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Object o) {
            Size s = (Size)o;
            if (this.height > s.height && this.weight > s.weight) {
                return -1;
            } else if (this.height < s.height && this.weight < s.weight) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
