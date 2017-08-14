package fall2; /**
 * Created by wang-zhenjun on 2016/10/15.
 */


import java.util.*;
import java.lang.*;

public class MainB {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int res_by_v = o1.getValue().compareTo(o2.getValue());
                if (res_by_v > 0) {
                    return -1;
                } else if (res_by_v < 0) {
                    return 1;
                }

                int res_by_k = o1.getKey().compareTo(o2.getKey());
                if (res_by_k > 0) {
                    return 1;
                } else if (res_by_k < 0) {
                    return -1;
                }
                return 0;
            }
        });

        HashMap<String, Integer> ht = new HashMap<>();

        for (int i = 0; i < str.length() - 1; ++i) {
            String bg = str.substring(i, i + 2);
            if (ht.containsKey(bg)) {
                ht.put(bg, ht.get(bg) + 1);
            } else {
                ht.put(bg, 1);
            }
        }

        for (Map.Entry<String, Integer> entry: ht.entrySet()) {
            pq.add(entry);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getKey());
        }
    }
}