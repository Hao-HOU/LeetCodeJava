package com.acehouhao;

/**
 * Created by Hao HOU on 2017/5/30.
 */
public class P35SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int mid;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        System.out.println("Position: " + searchInsert(nums, target));
    }
}
