package fall1; /**
 * Created by wang-zhenjun on 2016/10/15.
 */

import java.util.*;

public class MainC {
    static int value;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];

        int sum = 0;
        for (int i = 0; i < N; ++i) {
            A[i] = sc.nextInt();
            sum += A[i];
        }

        sc.close();

        int res_max = 1000000;
        int res_min = sum;
        int max_order_num = fact(N);
        int order = 0;
        int min_diff = Math.min(res_max - K, K - res_min);

        // boolean should_stop = false;
        while (order < max_order_num) {
            dfs(A, 1, A[0], K, min_diff);

            if (min_diff > Math.abs(value - K)) {
                min_diff = Math.abs(value - K);
            }
            nextPermutation(A);

            order++;
        }



        System.out.println(min_diff);
    }

    public static void dfs(int[] nums, int i, int cur, int K, int min_diff) {
        if (i >= nums.length) {
            if (Math.abs(cur - K) < min_diff) {
                min_diff = Math.abs(cur - K);
                value = cur;
            }
            return;
        }

        dfs(nums, i + 1, cur + nums[i], K, min_diff);
        dfs(nums, i + 1, cur * nums[i], K, min_diff);
    }

    public static void nextPermutation(int[] nums) {
        // 1. find ParitionNumber that violate increasing order R -> L
        int P = -1, P_idx = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                P = nums[i - 1];
                P_idx = i - 1;
                break;
            }
        }
        if (P_idx == -1) {
            reverseArray(nums, 0, nums.length - 1);
            return;
        }
        // 2. find the first number which > ParitionNumber R -> L
        int C = -1, C_idx = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > P) {
                C = nums[i];
                C_idx = i;
                break;
            }
        }
        // 3. swap P and C
        nums[P_idx] = C;
        nums[C_idx] = P;
        // 4. reverse the part right to P
        reverseArray(nums, P_idx + 1, nums.length - 1);

        return;
    }

    public static void reverseArray(int[] nums, int startIdx, int endIdx) {
        int i = startIdx;
        int j = endIdx;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static int fact(int n) {
        int r = 1;
        while (n > 0) {
            r *= n;
            n--;
        }

        return r;
    }
}
