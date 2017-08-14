/**
 * Created by wang-zhenjun on 2016/10/15.
 */

import java.util.*;

public class FriendlyRabbits {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] rb = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            rb[i + 1] = sc.nextInt();
        }
        sc.close();

        int res = 0;
        for (int i = 1; i <= N; ++i) {
            if (i == rb[rb[i]]) {
                res++;
            }
        }

        System.out.println(res / 2);
    }
}