package org.example.leetcode;

// https://leetcode.com/problems/reverse-linked-list/description/
// Time complexity = O(n)
// Space complexity = O(1)

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LC0206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

       while(curr != null)
        {
            // Trick: Save next node before update curr -> prev
            ListNode savedNext = curr.next;
            // 1) curr.next -> prev  (*link broken temporally*)
            // 2) prev = curr
            // 3) curr -> nxt
            curr.next = prev;
            prev = curr;
            curr = savedNext;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = reverseList(one);

        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
