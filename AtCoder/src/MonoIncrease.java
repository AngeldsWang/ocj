/**
 * Created by wang-zhenjun on 6/1/16.
 */

import java.util.Scanner;

public class MonoIncrease {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

        int l = 0, r = 0;
        long ans = 0;

        while ( l < N ) {
            if ( l == r ) r++;
            while (r < N && arr[r - 1] < arr[r]) {
                r++;
            }
            ans += r - l;
            l++;
        }

        System.out.println(ans);
    }
}
