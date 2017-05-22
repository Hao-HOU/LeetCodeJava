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

/**
 * 第一次提交：始终只能输出2个数字，发现链表第二个元素始终被重置，故引入temp来记住链表头部，然后追加next；
 * 第二次提交：1999999999，9用例报错，把变量大部分改为long，该用例通过，但更大的数值不能通过；
 * 第三次提交：为了保证不溢出，用了BigInteger，但是发现LeetCode不能使用BigInteger。
 * 综上，需要考虑新的解法，见版本2
 *
 * 版本2终于是Accepted了！！！刷题的时候需要专心，认真思考。
 */

public class P02AddTwoNumbers {
//    版本1
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        BigInteger value1 = BigInteger.valueOf(0);
//        BigInteger value2 = BigInteger.valueOf(0);
//        BigInteger multiplier = BigInteger.valueOf(1);
//        BigInteger sum = BigInteger.valueOf(0);
//        ListNode result;
//        ListNode temp;
//
//        while (l1 != null) {
//            value1 = BigInteger.valueOf(l1.val).multiply(multiplier).add(value1);
//            l1 = l1.next;
//            multiplier = BigInteger.valueOf(10).multiply(multiplier);
//        }
//
//        multiplier = BigInteger.valueOf(1);
//        while (l2 != null) {
//            value2 = BigInteger.valueOf(l2.val).multiply(multiplier).add(value2);
//            l2 = l2.next;
//            multiplier = BigInteger.valueOf(10).multiply(multiplier);
//        }
//
//        sum = value1.add(value2);
//        BigInteger remainder = sum.mod(BigInteger.valueOf(10));
//        sum = (sum.subtract(remainder)).divide(BigInteger.valueOf(10));
//        result = new ListNode(remainder.intValue());
//        temp = result;
//        while (sum != BigInteger.valueOf(0)) {
//            remainder = sum.mod(BigInteger.valueOf(10));
//            sum = (sum.subtract(remainder)).divide(BigInteger.valueOf(10));
//            result.next = new ListNode(remainder.intValue());
//            result = result.next;
//        }
//        result = temp;
//        return  result;
//    }

//    版本2
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;//用于判断l1还是l2长，使用长的那个保存最终结果
        ListNode h2 = l2;
        ListNode result;//生成结果的过程中使用
        ListNode head;//保存链表的头部
        int carry = 0;//表示进位
        int sum = 0;//对应位置的两数之和

        while (h1 != null && h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        //决定使用l1还是l2
        if (h1 != null){
            result = l1;
        } else {
            result = l2;
        }
        head = result;//记录头部位置

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum < 10) {
                result.val = sum;
                carry = 0;//无进位
            } else {
                result.val = sum - 10;
                carry = 1;//进位
            }
            l1 = l1.next;//向前移动
            l2 = l2.next;
            if (l1 != null || l2 != null) {
                result = result.next;//未到末尾时继续向前移动，已到末尾则停止
            }
        }

        ListNode notNull = null;//使用长的链表继续
        if (l1 != null) {
            notNull = l1;
        } else if (l2 != null) {
            notNull = l2;
        }
        while (notNull != null) {
            sum = notNull.val + carry;
            if (sum < 10) {
                result.val = sum;
                carry = 0;
            } else {
                result.val = sum - 10;
                carry = 1;
            }
            notNull = notNull.next;
            if (notNull != null) {
                result = result.next;
            }
        }

        if (carry == 1) {
            result.next = new ListNode(carry);
        }

        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
//        ListNode temp = l1;
//        for (int i = 0; i < 50; i++) {
//            l1.next = new ListNode(9);
//            l1 = l1.next;
//        }
//        l1 = temp;

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
