/**
 * Created by wang-zhenjun on 6/11/16.
 */

import java.util.Scanner;
import java.lang.Math;

public class SqrtBy4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        System.out.println((int)(Math.sqrt(Math.sqrt(X))));
    }
}
