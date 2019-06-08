/**
 * class ListNode { public int value; public ListNode next; public ListNode(int
 * value) { this.value = value; next = null; } }
 */
public class Solution {
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        // 注意画图理解base case，以及当前层的拼凑关系
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseInPairs(head.next.next);
        ListNode temp = head.next;
        head.next = newHead;
        temp.next = head;
        head = temp;
        return head;
    }
}
