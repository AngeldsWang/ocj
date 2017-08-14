/**
 * Created by wang-zhenjun on 2016/10/14.
 */

import java.util.*;

public class BestTimeToBuySell1 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int cur = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i - 1] >= prices[i]) {
                cur = Math.min(cur, prices[i]);
                continue;
            }

            max = Math.max(prices[i] - cur, max);
        }

        return max;
    }

    public static void main(String args[]) {
        BestTimeToBuySell1 s = new BestTimeToBuySell1();
        int max_profit = s.maxProfit(new int[]{7, 1, 3, 4, 7, 5});
        System.out.println(max_profit);
    }
}
