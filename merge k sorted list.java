/**
 * class ListNode { public int value; public ListNode next; public ListNode(int
 * value) { this.value = value; next = null; } }
 */
public class Solution {
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here/.
        // idea：every time we merge two sorted list into one, until we get one final
        // list
        Queue<ListNode> queue = new ArrayDeque<>();
        for (ListNode node : listOfLists) {
            queue.offer(node);
        }
        ListNode firstNode = null;
        if (listOfLists.size() % 2 == 1) {
            firstNode = queue.poll();
        }
        while (queue.size() >= 2) {
            queue.offer(helper(queue.poll(), queue.poll()));
        }
        if (listOfLists.size() % 2 == 1) {
            return helper(queue.poll(), firstNode);
        } else {
            return queue.poll();
        }
    }

    private ListNode helper(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode current1 = head1;
        ListNode current2 = head2;
        while (current1 != null || current2 != null) {
            if (current1 == null) {
                tail.next = current2;
                tail = tail.next;
                current2 = current2.next;
            } else if (current2 == null) {
                tail.next = current1;
                tail = tail.next;
                current1 = current1.next;
            } else {
                if (current1.value <= current2.value) {
                    tail.next = current1;
                    tail = tail.next;
                    current1 = current1.next;
                } else {
                    tail.next = current2;
                    tail = tail.next;
                    current2 = current2.next;
                }
            }
        }
        tail.next = null;
        return newHead.next;
    }
}
// Time: O(klog(k)) -- k = listOfLists.size()
// Space: O(k)