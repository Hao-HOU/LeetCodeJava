package com.acehouhao;

/**
 * Created by Hao HOU on 2017/5/29.
 */
public class P09PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String x_s = x + "";
        int i = 0;
        int j = x_s.length() - 1;
        while (i < j) {
            if (x_s.charAt(i) != x_s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        if (i >= j) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-12321));
    }
}
