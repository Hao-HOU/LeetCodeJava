package com.acehouhao;

/**
 * @author houhao
 */
public class P125ValidPalindrome {
    public static void main(String[] args) {
        String str = "a.";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindromePro(str));
        System.out.println(isPalindromeOpt(str));
    }

    public static boolean isPalindromeOpt(String s) {
        if (s == null) {
            return false;
        }
        if ("".equals(s.trim())) {
            return true;
        }
        String noPunc = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String noSpace = noPunc.replaceAll("\\s+", "");
        int i = 0;
        int j = noSpace.length() - 1;
        while (i < j) {
            if (noSpace.charAt(i) != noSpace.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    //最近的一次解法
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if ("".equals(s.trim())) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && j > i) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                if (i == j || i == j-1) {
                    return true;
                }
                i++;
                j--;
            }

        }
        return true;
    }

    //看到这个想法，才记起自己以前也这么做过，遇到简单的题其实应该多思考一会儿。
    //遇到难的题可以先写一个比较暴力的，然后再去优化。
    public static boolean isPalindromePro(String s) {
        String noPunc = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverse = new StringBuilder(noPunc).reverse().toString();
        return noPunc.equals(reverse);
    }
}
