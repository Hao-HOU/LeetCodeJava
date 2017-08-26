package com.acehouhao;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.

 * If the last word does not exist, return 0.

 * Note: A word is defined as a character sequence consists of non-space characters only.

 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 */
public class P58LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        if ("".equals(s) || s.equals(null)){
            return 0;
        }

        String[] words = s.trim().split(" ");

        String word = words[words.length - 1];
        return word.length();
    }

    public static void main(String[] args) {
        String string = "a ";
        System.out.println(lengthOfLastWord(string));
    }
}
