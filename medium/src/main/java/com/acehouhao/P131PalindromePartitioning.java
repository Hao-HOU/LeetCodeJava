package com.acehouhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houhao
 */
public class P131PalindromePartitioning {

    public static void main(String[] args) {
        String s = "abba";
//        List<List<String>> res = partition(s);
//        System.out.println("[");
//        for (List<String> stringList : res) {
//            System.out.print("  [");
//            for (String string : stringList) {
//                System.out.print("\"" + string + "\",");
//            }
//
//            System.out.println("],");
//        }
//        System.out.println("]");

        System.out.println(isPalindrome(s));
    }


    private static List<List<String>> partition(String s) {
        if (s.isEmpty()) {
            return null;
        }
        List<List<String>> res = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        String[] base = s.split("");
        stringList.addAll(Arrays.asList(base));
        res.add(stringList);
        stringList.clear();



        return res;
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

}
