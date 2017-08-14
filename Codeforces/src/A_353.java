/**
 * Created by wang-zhenjun on 5/18/16.
 */

import java.util.*;


public class A_353 {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        long a = stdin.nextLong();
        long b = stdin.nextLong();
        long c = stdin.nextLong();

        if (a < b) {
            if (c > 0 && (b-a) % c == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else if (a > b) {
            if (c < 0 && (a-b) % (-c) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("YES");
        }
    }
}
