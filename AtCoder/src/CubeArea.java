/**
 * Created by wang-zhenjun on 6/11/16.
 */

import java.util.Scanner;

public class CubeArea {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println((A*B + B*C + C*A) * 2);
    }
}
