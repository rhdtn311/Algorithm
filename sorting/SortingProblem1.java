import java.util.Arrays;
import java.util.Comparator;

public class SortingProblem1 {
    // 프로그래머스 lv 2 : 가장 큰 수 (https://programmers.co.kr/learn/courses/30/lessons/42746)

    // 실패한 코드 ( 퀵 정렬로 스스로 해봤는데 시간초과 뜸)
    public String solution(int[] numbers) {

        int zeroCount = 0;
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) zeroCount++;
            strings[i] = String.valueOf(numbers[i]);
        }
        if (zeroCount == numbers.length) return "0";

        quickSort(strings, 0, strings.length - 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
        }

        return result.toString();
    }

    public void quickSort(String[] strings, int start, int end) {

        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && checkLeft(strings[left], strings[pivot])) left++;
            while (right > start && checkRight(strings[right], strings[pivot])) right--;

            if (left > right) {
                swap(pivot, right, strings);
            } else {
                swap(left, right, strings);
            }
        }
        quickSort(strings, start, right - 1);
        quickSort(strings, right + 1, end);
    }

    public boolean checkLeft(String left, String pivot) {
        int leftIndex = 0;
        int pivotIndex = 0;

        while (true) {

            int leftValue = Character.getNumericValue(left.charAt(leftIndex));
            int pivotValue = Character.getNumericValue(pivot.charAt(pivotIndex));

            if (leftIndex == pivotIndex) {
                if (leftValue > pivotValue) {
                    return true;
                } else if (leftValue == pivotValue) {
                    if (leftIndex < left.length() - 1) {
                        leftIndex++;
                    }
                    if (pivotIndex < pivot.length() - 1) {
                        pivotIndex++;
                    }
                } else {
                    return false;
                }

            } else {

                int leftPivot = Integer.parseInt(left + pivot);
                int pivotLeft = Integer.parseInt(pivot + left);

                return leftPivot > pivotLeft;
            }
        }
    }

    public boolean checkRight(String right, String pivot) {
        int rightIndex = 0;
        int pivotIndex = 0;

        while (true) {
            int rightValue = Character.getNumericValue(right.charAt(rightIndex));
            int pivotValue = Character.getNumericValue(pivot.charAt(pivotIndex));

            if (rightIndex == pivotIndex) {
                if (rightValue > pivotValue) {
                    return false;
                } else if (rightValue == pivotValue) {
                    if (rightIndex < right.length() - 1) {
                        rightIndex++;
                    }
                    if (pivotIndex < pivot.length() - 1) {
                        pivotIndex++;
                    }
                } else {
                    return true;
                }
            } else {
                int rightPivot = Integer.parseInt(right + pivot);
                int pivotRight = Integer.parseInt(pivot + right);


                return rightPivot < pivotRight;
            }
        }
    }

    public void swap(int left, int right, String[] strings) {
        String temp = strings[left];
        strings[left] = strings[right];
        strings[right] = temp;
    }

    //--------------------------------------------------------------------------


    // 성공한 코드 Comparator을 이용 ( Integer.compare을 이용하면 더 쉽고 짧게 코딩 할 수 있음)
    public static void swap(String[] strings, int first, int second) {
        String temp = strings[first];
        strings[first] = strings[second];
        strings[second] = temp;
    }

    public static String method(int[] numbers) {
        String[] str = new String[numbers.length];
        int zeroCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) zeroCount++;

            str[i] = String.valueOf(numbers[i]);
        }
        if (zeroCount == numbers.length) return "0";

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int minLength = Math.min(o1.length(), o2.length());

                int sameCount = 0;
                for (int i = 0; i < minLength; i++) {
                    int first = Character.getNumericValue(o1.charAt(i));
                    int second = Character.getNumericValue(o2.charAt(i));

                    if (first > second) return -1;
                    else if (first < second) return 1;
                    else {
                        sameCount++;
                        if (sameCount == minLength) {
                            int firstSecond = Integer.parseInt(o1 + o2);
                            int secondFirst = Integer.parseInt(o2 + o1);

                            if (firstSecond > secondFirst) return -1;
                            else if (firstSecond == secondFirst) return 0;
                            else return 1;
                        }
                    }
                }
                return 0;
            }
        });


        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            result.append(str[i]);
        }
        return result.toString();
    }
}


