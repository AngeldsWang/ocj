/**
 * Created by wang-zhenjun on 2016/10/17.
 */
public class BestTimeToBuySell2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i - 1] >= prices[i]) continue;

            max += prices[i] - prices[i - 1];
        }

        return max;
    }

    public static void main(String args[]) {
        BestTimeToBuySell2 s = new BestTimeToBuySell2();
        int max_profit = s.maxProfit(new int[]{7, 1, 3, 4, 5, 5, 4, 5, 9});
        System.out.println(max_profit);
    }
}
