package com.acehouhao;

/**
 * @author houhao
 */
public class P647PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "aaaaa";
        System.out.println(countSubstrings(str));
    }

    //这个方案通过了，但是我自己都不知道为什么，测试用例太少！！！！！！！！！？？？
//    public static int countSubstrings(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        int cnt = 0;
//        for (int i = 0; i < s.length(); i++) {
//            cnt++;
//            int h = i - 1;
//            int j = i + 1;
//            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
//                cnt++;
//                j++;
//            }
//            while (h >= 0 && j < s.length()) {
//                if (s.charAt(h) == s.charAt(j)) {
//                    cnt++;
//                    h--;
//                    j++;
//                } else {
//                    break;
//                }
//            }
//        }
//        return cnt;
//    }

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt++;
            int b = isPalindromicSubstring(s, i, i+1, cnt);//双数回文
            int c = isPalindromicSubstring(s, i-1, i+1, b);//单数回文
            cnt = c;
        }
        return cnt;
    }

    private static int isPalindromicSubstring(String s, int left, int right, int cnt) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                cnt++;
                left--;
                right++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
