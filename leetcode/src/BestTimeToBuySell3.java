/**
 * Created by wang-zhenjun on 2016/11/14.
 */

import java.util.*;

public class BestTimeToBuySell3 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int[] max_1 = maxRange(prices);
        int max_l = 0;
        int max_r = 0;
        if (max_1[0] > 0) {
            int[] left = Arrays.copyOfRange(prices, 0, max_1[0]);
            int[] max_left = maxRange(left);
            if (max_left[2] > max_l) {
                max_l = max_left[2];
            }
        }

        if (max_1[1] < prices.length - 1) {
            int[] right = Arrays.copyOfRange(prices, max_1[1] + 1, prices.length);
            int[] max_right = maxRange(right);
            if (max_right[2] > max_r) {
                max_r = max_right[2];
            }
        }

        return max_1[2] + Math.max(max_l, max_r);
    }

    public int[] maxRange(int[] prices) {
        if (prices.length == 1) return new int[] {0, 0, 0};
        int cur = prices[0];
        int cur_idx = 0;
        int max = 0;
        int max_idx = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i - 1] >= prices[i]) {
                if (prices[i] < cur) {
                    cur_idx = i;
                    cur = prices[i];
                }
            } else {
                if (prices[i] - cur > max) {
                    max_idx = i;
                    max = prices[i] - cur;
                }
            }
        }

        return new int[] {cur_idx, max_idx, max};
    }

    public static void main(String args[]) {
        BestTimeToBuySell3 s = new BestTimeToBuySell3();
        int max_profit = s.maxProfit(new int[]{7, 1, 3, 4, 7, 5, 8});
        System.out.println(max_profit);
    }
}
