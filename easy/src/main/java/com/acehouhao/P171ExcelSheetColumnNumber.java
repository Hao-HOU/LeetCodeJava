package com.acehouhao;

import java.util.Scanner;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/5/14 14:33
 */
public class P171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(titleToNumber(s));
    }

    private static int titleToNumber(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int p = s.length() - 1;
        char[] chars = s.toCharArray();

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = chars[i] - 64;
            sum += Math.pow(26, p) * v;
            p--;
        }

        return sum;
    }
}
