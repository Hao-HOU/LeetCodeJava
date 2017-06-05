package com.acehouhao;

/**
 * Created by Hao HOU on 2017/6/5.
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 */
public class P21MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2.val <= l1.val) {
                result = new ListNode(l2.val);
                l2 = l2.next;
            }
        } else if (l1 != null) {
            result = new ListNode(l1.val);
            l1 = l1.next;
        } else if (l2 != null){
            result = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
                result = result.next;//注意此处！！！
            } else if (l2.val <= l1.val) {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
                result = result.next;//注意此处！！！
            }
        }
        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
