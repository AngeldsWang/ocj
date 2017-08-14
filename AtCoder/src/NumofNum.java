/**
 * Created by wang-zhenjun on 5/28/16.
 */

import java.util.*;

public class NumofNum {
    int A, B;

    public static int num(int n) {
        int t = 0;
        while(n > 0) {
            n /= 10;
            t++;
        }
        return t;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        NumofNum N = new NumofNum();

        N.A = s.nextInt();
        N.B = s.nextInt();

        int res = num(N.A) * num(N.B);
        System.out.println(res);
    }
}
