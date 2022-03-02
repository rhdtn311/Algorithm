package programmers_lv3;

import java.util.Arrays;

public class Solution2 {
        public static int solution(String[] lines) {
            int[] startTimes = new int[lines.length];
            int[] endTimes = new int[lines.length];
            int[] count = new int[lines.length];
            int max = -1;

            getTimes(lines, startTimes, endTimes);

            for (int i = 0; i < lines.length; i++) {
                int endFirst = endTimes[i] + 1000;

                for (int j = i; j < lines.length; j++) {
                    int startSecond = startTimes[j];
                    if (startSecond < endFirst) {
                        count[i]++;
                        max = Math.max(max, count[i]);
                    }
                }
            }

            return max;
        }

        public static void getTimes(String[] lines, int[] starts, int[] ends) {

            for (int i = 0; i < lines.length; i++) {
                String[] infos = lines[i].split(" ");
                String[] time = infos[1].split(":");

                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);
                double second = Double.parseDouble(time[2]);

                int endTime = hour * 3600000 + minute * 60000 + (int) (second * 1000);
                ends[i] = endTime;

                int process = (int)(Double.parseDouble(infos[2].replace("s", "")) * 1000);
                int startTime = endTime - process + 1;
                starts[i] = startTime;
            }
        }
}
