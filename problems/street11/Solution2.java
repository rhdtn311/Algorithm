package street11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {

        String solution = solution("'photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11");
        System.out.println(solution);
    }

    public static String solution(String S) {

        List<Photo> photos = new ArrayList<>();
        for (String photo : S.split("\\n")) {
            String[] infos = photo.split(",");

            String[] nameAndExtension = infos[0].trim().split("\\.");
            String name = nameAndExtension[0];
            String extension = nameAndExtension[1];

            String city = infos[1].trim();

            LocalDateTime time = LocalDateTime.parse(infos[2].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            photos.add(new Photo(name, extension, city, time));
        }

        Map<String, Integer> cityNums = new HashMap<>();
        for (Photo photo : photos) {
            cityNums.put(photo.city, cityNums.getOrDefault(photo.city, 0) + 1);
        }

        List<Photo> copyPhotos = new ArrayList<>(photos);
        Collections.sort(copyPhotos);

        for (String city : cityNums.keySet()) {
            int order = 1;
            int size = cityNums.get(city);

            for (Photo photo : copyPhotos) {
                if (photo.city.equals(city)) {
                    String nowOrder = String.valueOf(order);
                    while (nowOrder.length() < String.valueOf(size).length()) {
                        nowOrder = "0" + nowOrder;
                    }

                    photo.order = nowOrder;
                    order++;
                }
            }
        }

        for (Photo copyPhoto : copyPhotos) {
            for (Photo photo : photos) {
                if (copyPhoto.time == photo.time) photo.order = copyPhoto.order;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < photos.size(); i++) {
            Photo photo = photos.get(i);
            String name = photo.city + photo.order + "." + photo.extend;
            answer.append(name).append("\n");
        }

        return answer.toString();
    }

    static class Photo implements Comparable<Photo> {
        String name;
        String extend;
        String city;
        LocalDateTime time;
        String order;

        public Photo(String name, String extension, String city, LocalDateTime time) {
            this.name = name;
            this.extend = extension;
            this.city = city;
            this.time = time;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        @Override
        public int compareTo(Photo o) {
            return this.time.compareTo(o.time);
        }
    }
}
