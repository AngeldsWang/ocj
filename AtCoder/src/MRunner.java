/**
 * Created by wang-zhenjun on 7/9/16.
 */

import java.util.*;

public class MRunner {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(A*K);

        Long h = new Long(Math.min(A * K, B * K));
        Long l = new Long(0);
        System.out.printf("%d\n", h);

        double high = (double)h;
        double low  = (double)l;

        while (high - low > 10e-16) {
            double mid = (high + low) / 2;
            if ( check(mid, A, B, K) ) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.printf("%f\n", high);
        System.out.printf("%f\n", low);

        if (high - Math.floor(high) < 10e-5) {
            System.out.println("Takahashi");
        } else {
            System.out.println("Aoki");
        }
    }

    public static boolean check(double x, int A, int B, int K) {
        if ( (int)x/A + (int)(x - 0.5)/B >= K ) {
            return true;
        }

        return false;
    }
}
