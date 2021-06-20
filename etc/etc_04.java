import java.util.ArrayList;
import java.util.Arrays;

public class etc_04 {
    public String solution(int[] numbers, String hand) {
        // 프로그래머스 lv1 : 키패드 누르기 (https://programmers.co.kr/learn/courses/30/lessons/67256)

        int leftXValue = 0;
        int leftYValue = 3;
        int rightXValue = 2;
        int rightYValue = 3;
        int buttonXValue = 0;
        int buttonYValue = 0;
        String[][] array = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}};
        ArrayList<String> result = new ArrayList<>();

        for(int i : numbers) {

            if (i == 1 || i == 4 || i == 7) {
                result.add("L");
                leftXValue = 0;
                switch (i) {
                    case 1 :
                        leftYValue = 0;
                        continue;
                    case 4 :
                        leftYValue = 1;
                        continue;
                    case 7 :
                        leftYValue = 2;
                        continue;
                }
                continue;
            } else if (i == 3 || i == 6 || i == 9) {
                result.add("R");
                rightXValue = 2;
                switch (i) {
                    case 3 :
                        rightYValue = 0;
                        continue;
                    case 6 :
                        rightYValue = 1;
                        continue;
                    case 9 :
                        rightYValue = 2;
                        continue;
                }
                continue;
            } else {
                String str = Integer.toString(i);

                if (str.equals("1") || str.equals("2") || str.equals("3")) {
                    buttonYValue = 0;
                } else if (str.equals("4") || str.equals("5") || str.equals("6")) {
                    buttonYValue = 1;
                } else if (str.equals("7") || str.equals("8") || str.equals("9")) {
                    buttonYValue = 2;
                } else {
                    buttonYValue = 3;
                }
                for (String[] arr : array) {
                    int i1 = Arrays.asList(arr).indexOf(str);
                    if (i1 >= 0) {
                        buttonXValue = i1;
                    }
                }

                if ((Math.abs(leftXValue - buttonXValue) + Math.abs(leftYValue - buttonYValue)) >
                        (Math.abs(rightXValue - buttonXValue) + Math.abs(rightYValue - buttonYValue))) {
                    rightXValue = buttonXValue;
                    rightYValue = buttonYValue;
                    result.add("R");

                } else if (Math.abs(leftXValue - buttonXValue) + Math.abs(leftYValue - buttonYValue) <
                        Math.abs(rightXValue - buttonXValue) + Math.abs(rightYValue - buttonYValue)) {
                    leftXValue = buttonXValue;
                    leftYValue = buttonYValue;
                    result.add("L");
                } else {
                    if (hand.equals("right")) {
                        rightXValue = buttonXValue;
                        rightYValue = buttonYValue;
                        result.add("R");
                    } else if (hand.equals("left")) {
                        leftXValue = buttonXValue;
                        leftYValue = buttonYValue;
                        result.add("L");
                    }
                }
            }
        }
        String answer = result.toString();
        return answer.substring(1,answer.length()-1).replaceAll(",","").replaceAll("\\p{Z}","");
    }
}
