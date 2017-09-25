package com.acehouhao;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * 题解：因为一次只能跨1步或者2步，那么到n的最后一跨的时候可能是1步或2步，
 * 然后考虑前n-1步和前n-2步怎么跨，加起来就是n步总的跨法。
 *
 * @author houhao
 */
public class P70ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int ways = 0;
        int nextToLast = 1;
        int last = 2;
        for (int i = 3; i <= n; i++) {
            ways = nextToLast + last;
            nextToLast = last;
            last = ways;
        }

        return ways;
    }
}
