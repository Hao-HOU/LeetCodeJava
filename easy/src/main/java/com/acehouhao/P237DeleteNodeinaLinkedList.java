package com.acehouhao;

/**
 * @author houhao
 */
public class P237DeleteNodeinaLinkedList {

     //Definition for singly-linked list.
     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

    }

    public void deleteNode(ListNode node) {
         while (node.next != null) {

         }
    }
}
