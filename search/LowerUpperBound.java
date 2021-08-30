public class LowerUpperBound {

    public static int lowerBound() {
        int[] array = {1,1,1,2,2,3,3,4,4,5};
        int start = 0;
        int end = array.length;
        int target = 3;
        while(start < end) {
            int mid = (start + end) / 2;

            if (target > array[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static int upperBound() {
        int[] array = {1,1,1,2,2,3,3,4,4,5};
        int start = 0;
        int end = array.length;
        int target = 3;
        while(start < end) {
            int mid = (start + end) / 2;
            if (array[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
