package cloud.jnolasco.leetcode;

// https://leetcode.com/problems/reverse-linked-list/description/
// Time complexity = O(n)
// Space complexity = O(1)


import org.example.commons.ListNode;

public class LC0206_ReverseLinkedList {
     public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

       while(curr != null)
        {
            // Trick: Save next node before update curr -> prev
            ListNode next = curr.next;
            // 1) curr.next -> prev  (*link broken temporally*)
            // 2) prev = curr
            // 3) curr -> nxt
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);

        LC0206_ReverseLinkedList solution = new LC0206_ReverseLinkedList();
        ListNode result = solution.reverseList(one);

        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
