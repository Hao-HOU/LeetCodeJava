package com.acehouhao;

/**
 * Created by Hao HOU on 2017/6/3.
 */
public class P14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int shortest = strs[0].length();
        int p = 0;
        for (int i = 1; i < strs.length; i++) {
            if (shortest > strs[i].length()) {
                shortest = strs[i].length();
                p = i;
            }
        }
        String common = strs[p];

        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(common)){
                //i = 0; 错误，i++ 一次后为1，并不能重置
                i = -1;//注意此处，重置循环
                common = common.substring(0, common.length() - 1);
            }
        }

        return common;
    }

    public static void main(String[] args) {
        String[] strs = {
                "babb",
                "caa",
        };
        System.out.println(longestCommonPrefix(strs));
    }
}
