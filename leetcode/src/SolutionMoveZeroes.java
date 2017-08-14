/**
 * Created by wang-zhenjun on 5/20/16.
 */
public class SolutionMoveZeroes {
    public void moveZeroes(int[] nums) {
        int tmp;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

    public static void main(String args[]) {

    }
}
