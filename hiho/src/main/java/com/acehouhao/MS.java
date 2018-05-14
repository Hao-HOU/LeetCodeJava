package com.acehouhao;

import java.util.Arrays;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/4/2 19:12
 */
public class MS {
    public static void main(String[] args) {
        System.out.println(findUnlockKey(90909));
    }

    private static long findUnlockKey(long lockingKey) {
        if (lockingKey == 0) {
            return lockingKey;
        }

        if (lockingKey > 0) {
            String slk = String.valueOf(lockingKey);
            char[] slknums = slk.toCharArray();
            Arrays.sort(slknums);
            StringBuilder sb = new StringBuilder();

            int i = 0;
            char c = slknums[0];
            while (c == '0') {
                i++;
                c = slknums[i];
            }

            char tmp = slknums[0];
            slknums[0] = slknums[i];
            slknums[i] = tmp;

            for (char ch : slknums) {
                sb.append(ch);
            }

            return Long.parseLong(sb.toString());
        }

        lockingKey = -lockingKey;
        String slk = String.valueOf(lockingKey);
        char[] slknums = slk.toCharArray();
        Arrays.sort(slknums);
        StringBuilder sb = new StringBuilder();
        for (int i = slknums.length - 1; i >= 0;  i--) {
            sb.append(slknums[i]);
        }
        long res = Long.parseLong(sb.toString());
        return 0 - res;
    }
}
