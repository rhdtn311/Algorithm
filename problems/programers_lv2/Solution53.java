package programers_lv2;

import java.util.*;

public class Solution53 {
    public static int[] solution(int[] fees, String[] records) {

        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, List<Car>> cars = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");

            if (record[2].equals("OUT")) {
                Car car = cars.get(record[1]).get(cars.get(record[1]).size() - 1);
                car.out = record[0];
            } else {
                if (cars.get(record[1]) == null) {
                    cars.put(record[1], new ArrayList<>(List.of(new Car(Integer.parseInt(record[1]), record[0], null))));
                } else {
                    cars.get(record[1]).add(new Car(Integer.parseInt(record[1]), record[0], null));
                }
            }
        }

        String[] carNums = new String[cars.size()];
        int idx = 0;
        for (String num : cars.keySet()) {
            carNums[idx++] = num;
        }

        Arrays.sort(carNums);

        int[] result = new int[cars.size()];
        idx = 0;
        for (String carNum : carNums) {

            int minutes = 0;
            for (Car car : cars.get(carNum)) {

                String inTime = car.in;
                String outTime = car.out == null ? "23:59" : car.out;

                minutes +=getMinutes(inTime, outTime);
            }

            int resultFee = basicFee;
            if (minutes > basicTime) {
                resultFee += Math.ceil((double)(minutes - basicTime) / unitTime) * unitFee;
            }

            result[idx++] = resultFee;
        }

        return result;
    }

    public static int getMinutes(String inTime, String outTime) {
        int inHour = Integer.parseInt(inTime.substring(0, 2));
        int inMinutes = Integer.parseInt(inTime.substring(3));
        int outHour = Integer.parseInt(outTime.substring(0, 2));
        int outMinutes = Integer.parseInt(outTime.substring(3));

        int hours = inMinutes > outMinutes ? outHour - inHour - 1 : outHour - inHour;
        int minutes = inMinutes > outMinutes ? 60 + outMinutes - inMinutes : outMinutes - inMinutes;

        return hours * 60 + minutes;
    }

    public static class Car {
        int number;
        String in;
        String out;

        public Car(int number, String in, String out) {
            this.number = number;
            this.in = in;
            this.out = out;
        }
    }
}
