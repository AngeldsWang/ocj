/**
 * Created by wang-zhenjun on 7/2/16.
 */

import java.util.*;

public class RecyCount {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int p[] = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            p[i] = sc.nextInt();
        }

        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i<= N; ++i) {
            if (!set.contains(p[i])) {
                set.add( i );
                int j = p[i];

                do {
                    set.add( j );
                    j = p[j];
                } while (j != i);

                count++;
            }

            if (set.size() == N) {
                break;
            }
        }

        System.out.println(count);
    }
}
