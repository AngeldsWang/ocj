/**
 * Created by wang-zhenjun on 2016/09/27.
 */

import java.util.*;

public class MinAverageWaitingTime {

    public long minAverage(List<Customer> list) {
        int n = list.size();
        if (n == 0) return 0;

        // ensure customers will come in order
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.arrivalAt > o2.arrivalAt ? 1 : (o1.arrivalAt < o2.arrivalAt ? -1 : 0);
            }
        });

        PriorityQueue<Customer> pq = new PriorityQueue<>(n, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.workTime > o2.workTime ? 1 : (o1.workTime < o2.workTime ? -1 : 0);
            }
        });

        int cur_idx = 0;
        long cur_t  = list.get(cur_idx).arrivalAt;

        // since multiple customers might come together at the same time
        while (cur_idx < n && list.get(cur_idx).arrivalAt <= cur_t) {
            pq.add(list.get(cur_idx));
            cur_idx++;
        }

        long total = 0;
        while (!pq.isEmpty()) {
            Customer c = pq.poll();

            // pre-calculate current over time
            cur_t += c.workTime;
            total += cur_t - c.arrivalAt;

            // if there is no order coming temporarily
            // set the current over time to the time next order comes
            if (cur_idx < n && pq.isEmpty() && cur_t < list.get(cur_idx).arrivalAt) {
                cur_t = list.get(cur_idx).arrivalAt;
            }

            // add new orders which come before current over time
            while (cur_idx < n && list.get(cur_idx).arrivalAt <= cur_t) {
                pq.add(list.get(cur_idx));
                cur_idx++;
            }
        }

        return total / n;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            Customer c = new Customer(sc.nextInt(), sc.nextInt());
            customers.add(c);
        }

        sc.close();

        MinAverageWaitingTime s = new MinAverageWaitingTime();
        long average = s.minAverage(customers);

        System.out.println(average);
    }
}

class Customer {
    long arrivalAt;
    long workTime;

    Customer(long a, long w) {
        this.arrivalAt = a;
        this.workTime  = w;
    }
}
