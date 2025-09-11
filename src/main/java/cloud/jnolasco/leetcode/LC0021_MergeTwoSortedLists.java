package cloud.jnolasco.leetcode;

// https://leetcode.com/problems/merge-two-sorted-lists/
// Explanation 1: https://youtu.be/XIdigk956u0?si=e4SNvCRPyiR7tHAE
// Explanation 2: https://youtu.be/0ougDTvVOFI?si=uPUkcV4xDgWi9WzF
// Time complexity: O(m + n) = O(n)
// Space complexity: O(1)

public class LC0021_MergeTwoSortedLists {

    static class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy node to store the result. Common pattern in LeetCode problems
        ListNode dummy = new ListNode();   // dummy node
        ListNode tail = dummy;

        // Loop through both lists comparing the values and merging them into the result
        // when one list is exhausted then next step will be merging the remaining other list.
        while (list1 != null && list2 != null) {
            // Compare the values from both lists
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            // regardless of what list node come from, advance the tail
            tail = tail.next;
        }

        // At the end of the while loop, list1 or list2 will be null
        // If list1 is null, then tail.next will be the remaining part of list2
        // If list2 is null, then tail.next will be the remaining part of list1
        if (list1 != null)
            tail.next = list1;
        else if (list2 != null)
            tail.next = list2;

        return dummy.next;
    }

    public static void main(String[] args) {
        LC0021_MergeTwoSortedLists solution = new LC0021_MergeTwoSortedLists();

        // Create a hard-coded linked list:
        // 2 -> 4 -> 8 -> 9
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(9);

        // Create another hard-coded linked list:
        // 1 -> 3 -> 8 -> 10
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(8);
        b.next.next.next = new ListNode(10);

        ListNode temp = solution.mergeTwoLists(a, b);

        System.out.print("Merged Link List is:\n");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
    }
}

