package com.acehouhao;

/**
 * Created by Hao HOU on 2017/5/28.
 * 题目7,难度Easy
 * 需注意的是像100这样的输入，返回1即可；翻转后溢出则返回0.
 */
public class P07ReverseInteger {

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int x_reverse;
        boolean negative = false;
        int remainder;
        StringBuilder stringBuilder = new StringBuilder();
        if (x < 0) {
            x = -x;
            negative = true;
        }
        while (x != 0) {
            remainder = x % 10;
            stringBuilder.append(remainder);
            x = (x - remainder) / 10;
        }
        try {
            x_reverse = Integer.valueOf(stringBuilder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        if (negative) {
            x_reverse = -x_reverse;
        }
        return x_reverse;
    }


    public static void main(String[] args) {
        System.out.println(reverse(964632435));
    }
}
