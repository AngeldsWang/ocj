/**
 * Created by wang-zhenjun on 9/4/16.
 */

import java.util.*;

public class DisjointSet {
    int[] sz;
    int[] par;

    // par[i] = parent of the i-th node
    // sz[i]  = size of the set which i-th node belongs to
    public DisjointSet(int n) {
        par = new int[n + 1];
        sz = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            par[i] = i;
        }
        Arrays.fill(sz, 1);
    }

    public int findParent(int idx) {
        if (par[idx] == idx) return idx;
        return par[idx] = findParent(par[idx]);
    }

    public void merge(int u, int v) {
        int par_u = findParent(u);
        int par_v = findParent(v);

        if (par_u == par_v) return;

        par[par_v] = par_u;
        sz[par_u] += sz[par_v];
    }

    // example from: https://www.hackerrank.com/challenges/merging-communities
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] initNO = sc.nextLine().split(" ");
        int N = Integer.parseInt(initNO[0]);
        int O = Integer.parseInt(initNO[1]);

        DisjointSet ds = new DisjointSet(N);

        for (int i = 0; i < O; ++i) {
            String[] line = sc.nextLine().split(" ");
            if (line[0].equals("Q")) {
                int target = Integer.parseInt(line[1]);
                int hisParent = ds.findParent(target);
                System.out.println(ds.sz[hisParent]);
            } else if (line[0].equals("M")) {
                int target1 = Integer.parseInt(line[1]);
                int target2 = Integer.parseInt(line[2]);

                ds.merge(target1, target2);
            }
        }

        sc.close();
    }
}
