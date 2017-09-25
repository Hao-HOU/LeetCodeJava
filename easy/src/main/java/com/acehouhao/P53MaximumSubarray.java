package com.acehouhao;

/**
 * Find the contiguous subarray within an
 * array (containing at least one number) which
 * has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @author houhao
 */
public class P53MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-1,0, -2};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int newMax = nums[0];
        int oldMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            newMax = Math.max(newMax + nums[i], nums[i]);
            oldMax = Math.max(newMax, oldMax);
        }
        return oldMax;
    }
}
