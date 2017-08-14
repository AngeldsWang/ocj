/**
 * Created by wang-zhenjun on 2016/10/29.
 */

import java.io.*;
import java.util.*;

public class JanesFlowerShop {

    public static void main(String args[]) throws Exception {

        //String name = "C-small-practice";
        String name = "C-large-practice";
        String path = "";

        Scanner sc = new Scanner(new File(path + name + ".in"));
        PrintWriter pw = new PrintWriter(path + name + ".out");
//        Scanner sc = new Scanner(System.in);
//        PrintWriter pw = new PrintWriter(System.out);

        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            int M = sc.nextInt();
            int[] p = new int[M + 1];
            for (int j = 0; j <= M; ++j) {
                p[j] = sc.nextInt();
            }
            double result = solve(p);
            pw.printf("Case #%d: %.12f\n", (i + 1), result);
            pw.flush();
        }

        pw.close();
        sc.close();
    }

    public static double solve(int p[]) {
        double low = -1.0;
        double high = 1.0;

        double res = (low + high) / 2;
        int diff = calc(p, res);

        while (high - low > 1e-15) {
            if (diff > 0) {
                low = res;
            } else if (diff < 0) {
                high = res;
            } else {
                break;
            }
            res = (low + high) / 2;
            diff = calc(p, res);
        }

        return res;
    }

    public static int calc(int p[], double res) {
        int n = p.length - 1;
        double sum = -1 * p[0] * Math.pow(1 + res, n);
        for (int i = n - 1; i >= 0; --i) {
            sum += p[n - i] * Math.pow(1 + res, i);
        }

        if (sum > 1e-15) {
            return 1;
        } else if (sum < -1e-15) {
            return -1;
        }

        return 0;
    }
}
