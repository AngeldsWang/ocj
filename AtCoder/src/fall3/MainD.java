package fall3;

/**
 * Created by wang-zhenjun on 2016/10/22.
 */

import java.util.*;

public class MainD {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] bc = new int[M][2];

        for (int i = 0; i < M; ++i) {
            bc[i][0] = sc.nextInt();
            bc[i][1] = sc.nextInt();
        }

        sc.close();

        int [] used = new int[N + 1];

        HashMap<Integer, HashSet<Integer>> ht = new HashMap<>();
        for (int i = 1; i <= N; ++i) {
            HashSet<Integer> av = new HashSet<>();
            for (int j = 1; j <= N; ++j) {
                if (i == bc[i][0] && j == bc[i][1]) continue;
                av.add(j);
            }

            ht.put(i, av);
        }


    }

    public static int[] dfs(HashMap<Integer, Boolean> ht, int cur)
}
