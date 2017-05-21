package com.acehouhao;

/**
 * Created by Hao HOU on 2017/5/21.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    if ((nums[i] + nums[j]) == target) {
                        result[1] = j;
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        int[] result = new TwoSum().twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
