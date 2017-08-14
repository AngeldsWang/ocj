/**
 * Created by wang-zhenjun on 8/27/16.
 */

import java.util.*;

public class SingleNum {
    public int singleNumber(int[] nums) {
        int s = 0;

        for (int n: nums) {
            s ^= n;
        }

        return s;
    }

    public static void main(String args[]) {
        SingleNum s = new SingleNum();
        int res = s.singleNumber(new int[] {2, 2, 5, 7, 7, 91, 5, 4, 8, 8, 4});
        System.out.println(res);
    }
}
