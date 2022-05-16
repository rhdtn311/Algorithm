package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            rooms[i] = new Room(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(rooms);

        int count = 1;
        int now = rooms[0].end;
        for (int i = 1; i < n; i++) {
            if (now <= rooms[i].start) {
                count++;
                now = rooms[i].end;
            }
        }
        System.out.println(count);
    }

    static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (this.end > o.end) {
                return 1;
            } else if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Room{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
