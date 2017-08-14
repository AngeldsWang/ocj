/**
 * Created by wang-zhenjun on 8/23/16.
 */

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> ht = new HashMap<>();

        int[] res = new int[2];

        for (int i = 0; i < nums.length; ++i) {
            if (!ht.containsKey(nums[i])) {
                ht.put(target - nums[i], i);
            } else {
                res[0] = ht.get(nums[i]);
                res[1] = i;
                break;
            }
        }

        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }
        }

        return res;
    }

    public static void main(String args[]) {
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(new int[] {3, 2, 4}, 9);
        System.out.println(Arrays.toString(res));

        res = ts.twoSum2(new int[] {5, 25, 75}, 100);
        System.out.println(Arrays.toString(res));
    }
}
