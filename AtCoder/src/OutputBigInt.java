/**
 * Created by wang-zhenjun on 6/5/16.
 */

import java.util.*;
import java.lang.StringBuilder;

public class OutputBigInt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder("1");

        for (int i = 1; i < N; ++i) {
            sb.append('0');
        }
        sb.append('7');

        System.out.println(sb.toString());
    }
}

