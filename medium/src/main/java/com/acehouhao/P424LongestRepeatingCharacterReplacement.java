package com.acehouhao;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houhao
 */
public class P424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "ABABAB";
        int k = 2;
        System.out.println(characterReplacement(str, k));
    }

    public static int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        int maxCount = 0;
        int[] countLetters = new int[26];
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++countLetters[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                countLetters[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
