package fall1; /**
 * Created by wang-zhenjun on 2016/10/15.
 */


import java.util.*;

public class MainB {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] A = new int[N][M];
        int[][] B = new int[M][K];
        int[][] res = new int[N][K];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < K; ++j) {
                B[i][j] = sc.nextInt();
            }
        }

        sc.close();


        for (int i = 0; i < N; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < K; ++j) {
                for (int k = 0; k < M; ++k) {
                    res[i][j] += A[i][k] * B[k][j];
                }
                sb.append(res[i][j]).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
