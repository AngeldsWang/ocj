/**
 * Created by wang-zhenjun on 8/27/16.
 */

import java.util.*;

public class SingleNum3 {
    public int[] singleNumber(int[] nums) {
        int[] ret = {0, 0};

        int s = 0;
        for (int n: nums) {
            s ^= n;
        }

        // get the last bit
        s &= -s;

        for (int n: nums) {
            if ((n & s) == 0) {
                ret[0] ^= n;
            } else {
                ret[1] ^= n;
            }
        }

        return ret;
    }

    public static void main(String args[]) {
        SingleNum3 s = new SingleNum3();

        int[] ans = s.singleNumber(new int[] {1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ans));
    }
}
