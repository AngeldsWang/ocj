/**
 * Created by wang-zhenjun on 6/25/16.
 */

import java.util.Scanner;

public class PartCar {

    static boolean visited[];
    static boolean parted[];
    static Edge[] first;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();

        visited = new boolean[N + 1];
        parted = new boolean[N + 1];
        first = new Edge[N + 1];

        for (int i = 0; i < M; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            new Edge(u, v);
            new Edge(v, u);
        }

        for (int i = 1; i <= N; ++i) {
            dfs(S, i);

            if (parted[i]) {
                System.out.println(i);
            }
        }
    }

    public static void dfs(int x, int target) {
        visited[x] = true;

        if (x == target) {
            parted[target] = true;
            return;
        }

        for (Edge e = first[x]; e != null; e = e.next) {
            if (!visited[e.to]) {
                dfs(e.to, target);
            }
        }
    }

    public static class Edge {
        int to;
        Edge next;

        Edge(int from, int to) {
            this.to = to;
            this.next = first[from];
            first[from] = this;
        }
    }

}


