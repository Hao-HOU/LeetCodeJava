package com.acehouhao;

/**
 * Created by Hao HOU on 2017/6/5.
 *
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array nums = [1,1,2], Your function should return length = 2,
 * with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 *
 */
public class P26RemoveDuplicatesFromSortedArray {
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;//数组为空，直接返回
        }
        int max = nums[nums.length-1];//有序数组最后一个为最大值
        int i = 0;//不重复数字的当前位置
        int j = 1;//下一个不重复数字的位置

        while (nums[i] <= max && j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;//与已写好的最后一个数字相同，则向前移动
            } else {
                i++;//即将写入数字的位置
                nums[i] = nums[j];//写入这个不重复值
                j++;//向后移动
            }
        }
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
