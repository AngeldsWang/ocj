/**
 * Created by wang-zhenjun on 9/4/16.
 */

import java.util.*;

public class FindRunningMedian {
    PriorityQueue<Integer> left, right;

    public FindRunningMedian() {
        left = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        right = new PriorityQueue<>();
    }

    public void insert(int n) {
        if (left.isEmpty() && right.isEmpty()) {
            left.add(n);
            return;
        }

        if (left.size() < right.size()) {

            int right_min = right.peek();
            if (n <= right_min) {
                left.add(n);
            } else {
                left.add(right_min);
                right.poll();
                right.add(n);
            }

        } else if (left.size() > right.size()) {

            int left_max = left.peek();
            if (n >= left_max) {
                right.add(n);
            } else {
                right.add(left_max);
                left.poll();
                left.add(n);
            }

        } else {
            if (n > right.peek()) {
                right.add(n);
            } else {
                left.add(n);
            }
        }
    }

    public double getCurrentMedian() {
        int left_s = left.size();
        int right_s = right.size();

        double mid = 0.0;

        if (left_s == right_s + 1) {
            mid = (double)left.peek();
        } else if (right_s == left_s + 1) {
            mid = (double)right.peek();
        } else if (left_s == right_s) {
            mid = (left.peek() + right.peek()) / 2.0;
        }

        return mid;
    }

    public static void main(String args[]) {
        FindRunningMedian m = new FindRunningMedian();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; ++i) {
            int target = sc.nextInt();
            m.insert(target);
            System.out.println(m.getCurrentMedian());
        }

        sc.close();
    }
}
