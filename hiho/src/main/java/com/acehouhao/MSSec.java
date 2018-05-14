package com.acehouhao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/4/2 19:56
 */
public class MSSec {
    public static void main(String[] args) {
        String input = "ncncncnnncnccncnnn";
        System.out.println(annoncement(18, input));
    }

    private static String annoncement(int numOfNeighbors, String ch) {
        List<String> res = new ArrayList<>();
        List<Integer> cindex = new ArrayList<>();
        char[] chs = ch.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'c') {
                cindex.add(i);
            }
        }

        for (int i : cindex) {
            StringBuilder sb = new StringBuilder(ch);
            sb.setCharAt(i, 'I');
            boolean leftFlag = true;
            int leftIndex = i;
            while (i >= 2 && leftFlag) {
                leftFlag = false;
                if (ch.charAt(i - 1) == 'c') {
                    leftIndex = i - 1;
                    leftFlag = true;
                }
                if (ch.charAt(i - 2) == 'c') {
                    leftIndex = i - 2;
                    leftFlag = true;
                }

                sb.setCharAt(i - 1, 'I');
                sb.setCharAt(i - 2, 'I');

                i = leftIndex;
            }

            boolean rightFlag = true;
            int rightIndex = i;

            while (i <= ch.length() - 3 && rightFlag) {
                rightFlag = false;
                if (ch.charAt(i + 1) == 'c') {
                    rightIndex = i + 1;
                    rightFlag = true;
                }
                if (ch.charAt(i + 2) == 'c') {
                    rightIndex = i + 2;
                    rightFlag = true;
                }

                sb.setCharAt(i + 1, 'I');
                sb.setCharAt(i + 2, 'I');

                i = rightIndex;
            }

            for (int k = 0; k < sb.length(); k++) {
                if (sb.charAt(k) != 'I') {
                    sb.setCharAt(k, 'U');
                }
            }

            res.add(sb.toString());
            System.out.println(sb.toString());
        }

        Collections.sort(res);

        return res.get(res.size() - 1);

    }
}
