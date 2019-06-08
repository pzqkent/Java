/**
 * class ListNode { public int value; public ListNode next; public ListNode(int
 * value) { this.value = value; next = null; } }
 */
/*
 * hint 1.find the middle point of the original linked list and split the linked
 * list into two halves 2.sort two halves 2.merge two halves
 */

public class Solution {
    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);

    }

    public ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (left != null) {
            if (right == null) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
                continue;
            }
            if (left.value > right.value) {
                tail.next = right;
                right = right.next;
            } else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }
        if (left == null && right != null) {
            tail.next = right; // notice that when left equals null, we need to check if the right linked list
                               // is also totally went through
        } else {
            tail.next = null;
        }

        return dummyHead.next;

    }
}
// Time: O(nlog(n)); #of call stack: log(n), Time complexity per call stack:
// O(n)
// Space: O(log(n)); space on call stack;
