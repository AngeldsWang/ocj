/**
 * Created by wang-zhenjun on 7/23/16.
 */

import java.util.*;
import java.lang.*;

public class DislikeNum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int Dk[] = new int[10];
        int mmin = 10;
        for (int i = 0; i < K; ++i) {
            int idx = sc.nextInt();
            Dk[idx] = 1;
        }
        for (int i = 0; i < 10; ++i) {
            if(Dk[i] == 0) {
                mmin = i;
                break;
            }
        }

        int num[] = new int[5];
        Arrays.fill(num, -1);
        int sum = N;
        int j = 0;
        while (sum > 0) {
            int n = sum % 10;
            sum /= 10;
            num[j] = n;
            j++;
        }

        boolean is_bigger = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 4; i >= 0; --i) {
            if (num[i] == -1) continue;
            if (is_bigger) break;
            int n = num[i];

            while (n <= 9 && Dk[n] == 1) {
                n++;
            }

            if (n > num[i]) {
                is_bigger = true;
            }

            if (n > 9) {
                int last = Character.getNumericValue(sb.charAt(sb.length() - 1));
                last++;
            } else {
                sb.append(n);
            }
        }

        if (!is_bigger) {
            System.out.println(N);
        } else {
            while (j - 1 > 0) {
                sb.append(mmin);
                j--;
            }
            System.out.println(sb.toString());
        }
    }
}
