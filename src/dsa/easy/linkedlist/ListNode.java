package dsa.easy.linkedlist;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    ListNode(int x, ListNode next) { val = x; this.next = next;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        return sb.toString();
    }

    public static ListNode getSampleList(int max) {
        ListNode next = null;
        ListNode node = null;
        for (int i = max; i >= 1; i--) {
            node = new ListNode(i, next);
            next = node;
        }
        return node;
    }

    public static ListNode getSamplePalindromeList(int[] arr) {
        ListNode next = null;
        ListNode node = null;
        for (int i = 0; i < arr.length; i++) {
            node = new ListNode(arr[i], next);
            next = node;
        }
        return node;
    }

}
