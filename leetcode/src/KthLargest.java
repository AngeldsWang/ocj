/**
 * Created by wang-zhenjun on 8/27/16.
 */

import java.util.*;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n: nums) {
            pq.add(n);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String args[]) {
        KthLargest s = new KthLargest();

        int kth = s.findKthLargest(new int[] {3,2,1,5,6,4}, 2);

        System.out.println(kth);
    }
}
