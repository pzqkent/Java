/**
 * class ListNode { public int value; public ListNode next; public ListNode(int
 * value) { this.value = value; next = null; } }
 */
public class Solution {
    public ListNode reverse(ListNode head) {
        // Write your solution here
        // recursion 实现链表反转
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }
}
