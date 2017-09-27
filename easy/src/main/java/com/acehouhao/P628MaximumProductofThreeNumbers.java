package com.acehouhao;

import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose
 * product is maximum and output the maximum product.
 *
 * NOTE:
 * 1. The length of the given array will be in range [3,10^4] and
 *    all elements are in the range [-1000, 1000].
 * 2. Multiplication of any three numbers in the input won't
 *    exceed the range of 32-bit signed integer.
 *
 * @author houhao
 */
public class P628MaximumProductofThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {-500, -6, -7, 8};
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProductPro(nums));
        System.out.println(maximumProductBest(nums));
    }

    //先来一个三层循环的，小测试数组能成，数组稍微大点肯定超时
    public static int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    max = Math.max(max, nums[i] * nums[j] * nums[k]);
                }
            }
        }
        return max;
    }

    //怎么去掉3层循环呢？
    //动态规划？没看到子结构啊！我再想想。动态规划行不通！
    //只要最大的三数乘积，所以可以先排序，然后再寻找最大三数乘积。
    public static int maximumProductPro(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int max = nums[0] * nums[1] * nums[2];
        max = Math.max(max, nums[length-3] * nums[length-2] * nums[length-1]);
        max = Math.max(max, nums[0] * nums[1] * nums[length-1]);

        return max;
    }

    //参考他人的代码，不需要Arrays.sort()，直接获得最大的三个数和最小的两个数。
    public static int maximumProductBest(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
