/**
 * Created by wang-zhenjun on 6/1/16.
 */

import java.util.Scanner;

public class HighEquWidth {

    public static void main(String args[]) {
        int h1, w1, h2, w2;

        Scanner sc = new Scanner(System.in);

        h1 = sc.nextInt();
        w1 = sc.nextInt();
        h2 = sc.nextInt();
        w2 = sc.nextInt();

        if ( h1 == h2 || h1 == w2 || w1 == w2 || w1 == h2 ) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
