/**
 * Created by wang-zhenjun on 8/27/16.
 */

import java.util.*;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];

        Arrays.fill(res, 1);

        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int c: res) {
            sum += c;
        }

        return sum;
    }

    public static void main(String args[]) {
        Candy s = new Candy();
        int sum = s.candy(new int[] {5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1});

        System.out.println(sum);
    }
}
