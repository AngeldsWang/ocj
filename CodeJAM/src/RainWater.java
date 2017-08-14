/**
 * Created by wang-zhenjun on 2016/10/29.
 */

import java.util.*;
import java.io.*;

public class RainWater {

    public static final int[][] dir = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static int R, C;
    public static int[][] H;
    public static boolean[][] visited;
    public static PriorityQueue<Node> pq;

    public static void main(String args[]) throws Exception {

//        String name = "B-small-practice";
        String name = "B-large-practice";
        String path = "";

        Scanner sc = new Scanner(new File(path + name + ".in"));
        PrintWriter pw = new PrintWriter(path + name + ".out");
//        Scanner sc = new Scanner(System.in);
//        PrintWriter pw = new PrintWriter(System.out);


        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            R = sc.nextInt();
            C = sc.nextInt();

            H = new int[R][C];
            visited = new boolean[R][C];

            pq = new PriorityQueue<>(R * C, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.h > o2.h ? 1 : o1.h < o2.h ? -1 : 0;
                }
            });

            for (int j = 0; j < R; ++j) {
                for (int k = 0; k < C; ++k) {
                    H[j][k] = sc.nextInt();
                    if (j == 0 || j == R - 1 || k == 0 || k == C - 1) {
                        Node node = new Node(j, k, H[j][k]);
                        pq.add(node);
                        visited[j][k] = true;
                    }
                }
            }

            int result = solve();
            pw.printf("Case #%d: %d\n", (i + 1), result);
            pw.flush();
        }

        pw.close();
        sc.close();
    }

    public static int solve() {
        int res = 0;
        while (!pq.isEmpty()) {
            Node start = pq.poll();

            for (int d = 0; d < dir.length; ++d) {
                int new_x = start.x + dir[d][0];
                int new_y = start.y + dir[d][1];
                if ( new_x >= 0 && new_x < R && new_y >= 0 && new_y < C && !visited[new_x][new_y] ) {
                    Node next = new Node(new_x, new_y, Math.max(start.h, H[new_x][new_y]));
                    pq.add(next);
                    visited[new_x][new_y] = true;
                    res += Math.max(0, start.h - H[new_x][new_y]);
                }
            }
        }

        return res;
    }
}

class Node {
    int x, y, h;
    public Node (int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}
