/**
 * Created by wang-zhenjun on 8/25/16.
 */

import java.util.*;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int c = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            int added = digits[i] + c;
            c = added / 10;
            ans.add(added % 10);
        }
        if (c == 1) {
            ans.add(c);
        }
        Collections.reverse(ans);
        int[] res = ans.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    public static void main(String args[]) {
        PlusOne po = new PlusOne();
        int[] res = po.plusOne(new int[] {9, 9, 9});
        System.out.println(Arrays.toString(res));
    }
}
