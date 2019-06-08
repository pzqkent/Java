/**
 * class ListNode { public int value; public ListNode next; public ListNode(int
 * value) { this.value = value; next = null; } }
 */
/*
 * Idea: same as the question: reverse nodes in pair; Time: O(n); Acutally it is
 * 2 * O(n): forward O(n) for partition + backward O(n) for reverse; Space: call
 * Stack O(n/k)
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your solution here
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        int i = k; // be careful that we need to keep the value of k in order to use in next
                   // recursion
        while (i > 0) {
            if (current == null) {
                return head;
            }
            prev = current;
            current = current.next;
            i--;
        }
        ListNode left = head;
        ListNode right = prev.next;
        prev.next = null;
        left = reverse(left);
        ListNode tail = left;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        tail.next = reverseKGroup(right, k);
        return left;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
