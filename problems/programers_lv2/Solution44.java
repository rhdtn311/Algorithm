package programers_lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution44 {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int time = 0;
        List<String> cache = new ArrayList<>();

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                cache.remove(cache.indexOf(city));
                cache.add(city);
                time++;
            } else {
                time += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                    cache.add(city);
                } else {
                    cache.add(city);
                }
            }
        }

        return time;
    }
}
