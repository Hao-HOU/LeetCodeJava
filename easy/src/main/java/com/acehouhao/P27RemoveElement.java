package com.acehouhao;

/**
 * Created by Hao HOU on 2017/5/30.
 */
public class P27RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                length--;
            } else {
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                nums[i] = nums[length - 1];
                length--;
                for (int j = length - 1; j >= 0; j--) {
                    if (nums[j] == val) {
                        length--;
                    } else {
                        break;
                    }
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 4, 3, 5};
        int val = 3;
        System.out.println("re: " + removeElement(nums, val));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
