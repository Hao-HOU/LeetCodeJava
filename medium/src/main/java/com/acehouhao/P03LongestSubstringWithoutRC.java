package com.acehouhao;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hao HOU on 2017/5/23.
 */
public class P03LongestSubstringWithoutRC {
    public static int lengthOfLongestSubstring(String s) {
        int length;
        int result = 0;
        char[] chars = s.toCharArray();
        Set cs = new HashSet();
        for (int i = 0; i < chars.length; i++) {
            length = 0;
            for (int j = i; j < chars.length; j++) {
                if (cs.contains(chars[j])) {
                    break;
                } else {
                    cs.add(chars[j]);
                    length++;
                }
            }
            cs.clear();
            if (length > result) {
                result = length;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "thebackingHashMapinstancehasthespecifiedinitialcapacityandthespecifiedloadfactor";
        System.out.println(lengthOfLongestSubstring(s));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}
