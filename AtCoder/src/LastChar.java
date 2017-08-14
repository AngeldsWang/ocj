/**
 * Created by wang-zhenjun on 6/1/16.
 */

import java.util.Scanner;

public class LastChar {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        if ('T' == str.charAt(str.length() - 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
