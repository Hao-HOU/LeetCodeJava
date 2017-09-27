package com.acehouhao;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author houhao
 */
public class P506RelativeRanks {
    public static void main(String[] args) {
        int[] nums = {1};
        String[] r = findRelativeRanks(nums);
        for (String s : r) {
            System.out.println(s);
        }
    }

    public static String[] findRelativeRanks(int[] nums) {
        String[] ans = new String[nums.length];
        if (nums.length == 1) {
            ans[0] = "Gold Medal";
            return ans;
        }
        if (nums.length < 3) {
            if (nums[0] < nums[1]) {
                ans[1] = "Gold Medal";
                ans[0] = "Silver Medal";
            } else {
                ans[0] = "Gold Medal";
                ans[1] = "Silver Medal";
            }
            return ans;
        }
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            rank.put(nums[i], i);
        }
        int[] keys = new int[nums.length];
        int i = 0;
        for (int key : rank.keySet()) {
            keys[i++] = key;
        }
        Arrays.sort(keys);

        int len = keys.length;
        ans[rank.get(keys[len-1])] = "Gold Medal";
        ans[rank.get(keys[len-2])] = "Silver Medal";
        ans[rank.get(keys[len-3])] = "Bronze Medal";

        for (int j = keys.length - 4, k = 4; j >= 0; j--) {
            ans[rank.get(keys[j])] = "" + k;
            k++;
        }

        return ans;
    }
}
