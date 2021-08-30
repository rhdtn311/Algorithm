public class BinarySearch {

    // 이진 탐색
    public static int binarySearch() {

        int[] array = new int[] {1,4,7,11,15,21,24,27,30};
        int start = 0;
        int end = array.length - 1;
        int target = 11;
        while(start <= end) {

            int mid = (start + end) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
