package org.example.leetcode;

// https://leetcode.com/problems/add-two-numbers/
// Explanation: https://www.youtube.com/watch?v=KMS0WFxrsT8
// Time complexity: O(n)
// Space complexity: O(n)

import org.example.commons.ListNode;

public class LC0002_AddTwoNumbers {

    /*

     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultTail = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            resultTail.next = new ListNode(sum);
            resultTail = resultTail.next;

        }

        if(carry == 1)
            resultTail.next = new ListNode(1);

        return result.next;
    }

    public static void main(String[] args) {
        LC0002_AddTwoNumbers app = new LC0002_AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = app.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
