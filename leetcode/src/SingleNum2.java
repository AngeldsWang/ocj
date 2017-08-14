/**
 * Created by wang-zhenjun on 8/27/16.
 */

import java.util.*;

public class SingleNum2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }

            if (sum != 0) {
                ans |= sum << i;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        SingleNum2 s = new SingleNum2();

        int ans = s.singleNumber(new int[] {3, 4, 4, 3, 10, 4, 10, 3});
        System.out.println(ans);
    }
}
