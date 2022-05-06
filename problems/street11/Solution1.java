package street11;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {
    public static void main(String[] args) {

        int solution = solution(new int[]{1, 3, 4, 2, 5});
        System.out.println(solution);

    }

    public static int solution(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            pq.offer(A[i]);
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int off = A[i];
            int min = pq.peek();

            if (off == min) {
                count++;
            }

            pq.remove(off);
        }

        return count;
    }
}
