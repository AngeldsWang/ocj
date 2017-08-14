package div2_378;

/**
 * Created by wang-zhenjun on 2016/11/01.
 */

import java.util.*;

public class MainB {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];

        int L = 0;
        int R = 0;
        int max_diff = 0;

        for (int i = 0; i < n; ++i) {
            l[i] = sc.nextInt();
            L += l[i];
            r[i] = sc.nextInt();
            R += r[i];
        }

        sc.close();

        max_diff = Math.abs(L - R);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int diff = Math.abs(L - R + 2 * (r[i] - l[i]));
            if (diff > max_diff) {
                max_diff = diff;
                res = i + 1;
            }
        }

        System.out.println(res);
    }
}
