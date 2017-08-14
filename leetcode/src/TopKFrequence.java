/**
 * Created by wang-zhenjun on 8/28/16.
 */

import java.util.*;

public class TopKFrequence {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> ht = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int n: nums) {
            if (ht.containsKey(n)) {
                ht.put(n, ht.get(n) + 1);
            } else {
                ht.put(n, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry: ht.entrySet()) {
            pq.add(entry);
        }

        while (res.size() < k) {
            res.add(pq.poll().getKey());
        }

        return res;
    }

    public static void main(String args[]) {
        TopKFrequence s = new TopKFrequence();
        List<Integer> res = s.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
        System.out.println(res);
    }
}
