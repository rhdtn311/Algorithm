package programmers_lv3;

import java.util.*;

public class Solution10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        solution10.solution(new String[]{"classic", "pop", "classic", "classic", "pop" }, new int[]{500, 600, 150, 800, 2500});
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        TreeMap<Integer, PriorityQueue<Music>> treeMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String genre = entry.getKey();
            Integer sum = entry.getValue();
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    Music music = new Music(genre, plays[i], i);
                    if (treeMap.containsKey(sum)) {
                        treeMap.get(sum).add(music);
                    } else {
                        PriorityQueue<Music> pq = new PriorityQueue<>();
                        pq.offer(music);
                        treeMap.put(sum, pq);
                    }
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (Integer key : treeMap.descendingKeySet()) {
            for (int i = 0; i < 2; i++) {
                if (treeMap.get(key).size() >= 1) {
                    resultList.add(treeMap.get(key).poll().number);
                }
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    class Music implements Comparable<Music> {
        String genre;
        int playTime;
        int number;

        public Music(String genre, int playTime, int number) {
            this.genre = genre;
            this.playTime = playTime;
            this.number = number;
        }

        @Override
        public int compareTo(Music o) {
            if (this.playTime > o.playTime) {
                return -1;
            } else if (this.playTime == o.playTime) {
                return o.number - this.number;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Music{" +
                    "genre='" + genre + '\'' +
                    ", playTime=" + playTime +
                    ", number=" + number +
                    '}';
        }
    }

}
