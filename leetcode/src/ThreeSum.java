/**
 * Created by wang-zhenjun on 8/24/16.
 */

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    while (k > j && nums[k] == nums[k - 1]) k--;
                    k--;
                } else if (sum < 0) {
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                    while (k > j && nums[k] == nums[k - 1]) k--;
                    k--;
                }
            }
        }

        return res;
    }

    public static void main(String args[]) {
        ThreeSum s = new ThreeSum();

        int[] arr;
        arr = new int[] { -1, 0, 1, 2, -1, -4};
        for (List<Integer> a : s.threeSum(arr)) {
            System.out.println(a);
        }
        arr = new int[] { 0, 0, 0, 0};
        for (List<Integer> a : s.threeSum(arr)) {
            System.out.println(a);
        }

        arr = new int[] {};
        for (List<Integer> a : s.threeSum(arr)) {
            System.out.println(a);
        }
    }
}
