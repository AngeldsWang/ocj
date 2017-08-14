package fall2; /**
 * Created by wang-zhenjun on 2016/10/15.
 */

import java.util.Scanner;

public class MainC {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N + 1];
        int[][] ranges = new int[M][2];

        int sum = 0;
        for (int i = 1; i <= N; ++i) {
            A[i] = sc.nextInt();
            sum += A[i] * i;
        }

        for (int i = 0; i < M; ++i) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }

        sc.close();

        for (int i = 0; i < M; ++i) {
            int cur = sum - (A[ranges[i][0]] * ranges[i][0] + A[ranges[i][1]] * ranges[i][1]) +
                    A[ranges[i][0]] * ranges[i][1] + A[ranges[i][1]] * ranges[i][0];

            if (cur >= sum) {
                int tmp = A[ranges[i][0]];
                A[ranges[i][0]] = A[ranges[i][1]];
                A[ranges[i][1]] = tmp;
                sum = cur;
            }
        }

        System.out.println(sum);
    }
}