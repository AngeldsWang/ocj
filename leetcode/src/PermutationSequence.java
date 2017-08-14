/**
 * Created by wang-zhenjun on 8/20/16.
 */

import java.util.*;

public class PermutationSequence {
    public int fact(int n) {
        int r = 1;
        while (n > 0) {
            r *= n;
            n--;
        }

        return r;
    }

    public String getPermutation(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();


        for ( int i = 1; i <= n; ++i) {
            arr.add(i);
        }

        k -= 1;

        StringBuilder sb = new StringBuilder(n);
        for (int i = n - 1; i > 0; i--) {
            int fb = fact(i);
            int idx = k / fb;
            sb.append(arr.get(idx));
            arr.remove(idx);
            k %= fb;
        }

        sb.append(arr.get(0));
        return sb.toString();
    }

    public static void main(String args[]) {
        PermutationSequence ps = new PermutationSequence();

        String ps_str = ps.getPermutation(8, 8590);

        System.out.println(ps_str);
    }
}