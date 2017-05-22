package com.acehouhao;

import java.math.BigInteger;

/**
 * Created by Hao HOU on 2017/5/22.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class P02AddTwoNumbersV1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger value1 = BigInteger.valueOf(0);
        BigInteger value2 = BigInteger.valueOf(0);
        BigInteger multiplier = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);
        ListNode result;
        ListNode temp;

        while (l1 != null) {
            value1 = BigInteger.valueOf(l1.val).multiply(multiplier).add(value1);
            l1 = l1.next;
            multiplier = BigInteger.valueOf(10).multiply(multiplier);
        }

        multiplier = BigInteger.valueOf(1);
        while (l2 != null) {
            value2 = BigInteger.valueOf(l2.val).multiply(multiplier).add(value2);
            l2 = l2.next;
            multiplier = BigInteger.valueOf(10).multiply(multiplier);
        }

        sum = value1.add(value2);
        BigInteger remainder = sum.mod(BigInteger.valueOf(10));
        sum = (sum.subtract(remainder)).divide(BigInteger.valueOf(10));
        result = new ListNode(remainder.intValue());
        temp = result;
        while (sum != BigInteger.valueOf(0)) {
            remainder = sum.mod(BigInteger.valueOf(10));
            sum = (sum.subtract(remainder)).divide(BigInteger.valueOf(10));
            result.next = new ListNode(remainder.intValue());
            result = result.next;
        }
        result = temp;
        return  result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode temp = l1;
        for (int i = 0; i < 50; i++) {
            l1.next = new ListNode(9);
            l1 = l1.next;
        }
        l1 = temp;

        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
