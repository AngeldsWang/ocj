/**
 * Created by wang-zhenjun on 6/25/16.
 */

import java.util.Scanner;
import java.lang.Math;

public class BuyOrange {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long K = sc.nextInt();
        long L = sc.nextInt();

        int numSet = (int)(K / L);
        int extra  = (int)(K % L);

        long all = numSet * B + Math.min(extra * A, B);

        System.out.println(all);
    }
}
