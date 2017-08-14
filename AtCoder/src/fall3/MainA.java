package fall3; /**
 * Created by wang-zhenjun on 2016/10/15.
 */

import java.util.*;

public class MainA {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int pre = B;
        int cur = A + B;
        for (int i = 3; i <= 10; ++i) {
            int tmp = cur;
            cur += pre;
            pre = tmp;
        }


        System.out.println(pre);
    }
}
