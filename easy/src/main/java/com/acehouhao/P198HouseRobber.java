package com.acehouhao;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only
 * constraint stopping you from robbing each of them is that adjacent
 * houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * 解题：根据当前的房间抢还是不抢来确定子结构，如果不抢就取前n-1个房间的最大，如果抢
 * 就取前n-2个房间的最大然后加上当前房间钱数，接着取这两个数的最大值为n个房间的最大。
 *
 * @author houhao
 */
public class P198HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 6};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int r2p = nums[0];
        int r1p = Math.max(nums[0], nums[1]);
        int answer = r1p;
        for (int i = 2; i < nums.length; i++) {
            answer = Math.max(nums[i] + r2p, r1p);
            r2p = r1p;
            r1p = answer;
        }

        return answer;
    }
}
