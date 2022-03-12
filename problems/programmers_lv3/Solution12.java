package programmers_lv3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

public class Solution12 {
    public String solution(int n, int t, int m, String[] timetable) {

        PriorityQueue<LocalTime> timeQueue = new PriorityQueue<>();
        for (String time : timetable) {
            String[] hourMinutes = time.split(":");
            LocalTime crewTime = LocalTime.of(Integer.parseInt(hourMinutes[0]), Integer.parseInt(hourMinutes[1]));
            timeQueue.offer(crewTime);
        }

        LocalTime now = LocalTime.of(9, 0);
        while (n-- > 1) {
            int remain = m;
            while (!timeQueue.isEmpty() && remain > 0) {
                if (timeQueue.peek().isBefore(now) || timeQueue.peek().equals(now)) {
                    timeQueue.poll();
                    remain--;
                } else {
                    break;
                }
            }

            now = now.plusMinutes(t);
        }

        while (m-- > 1) {
            if (!timeQueue.isEmpty() && timeQueue.peek().isBefore(now)) {
                timeQueue.poll();
            }
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime result = now;
        if (!timeQueue.isEmpty()) {
            if (timeQueue.peek().isBefore(now) || timeQueue.peek().equals(now)) {
                result = timeQueue.peek().minusMinutes(1);
            }
        }

        return LocalTime.parse(result.toString(), format).toString();
    }
}
