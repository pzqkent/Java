/**
 * class ListNode { public int value; public ListNode next; public ListNode(int
 * value) { this.value = value; next = null; } }
 */
/*
 * 思路：新建一个链表，其头结点为dummynode 每次从原链表中依次分离出一个node，将其插入我们所建立的新链表中 edge case较多，仔细考虑
 * 
 */
public class Solution {
    public ListNode insertionSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode current = head;
        while (current != null) { // 遍历原链表
            ListNode next = current.next;
            current.next = null;
            if (dummyHead.next == null) { // 如果新链表只有一个dummyhead，则将新node直接插入
                dummyHead.next = current;
            } else {
                ListNode currentInner = dummyHead;
                while (currentInner != null && currentInner.next != null) { // 每次判断新链表指针指向的下一个node的大小和等待插入的node的大小关系
                    if (current.value < currentInner.next.value) {
                        ListNode temp = currentInner.next; // 插入我们待插入的元素
                        currentInner.next = current;
                        current.next = temp;
                        break;

                    } else {
                        currentInner = currentInner.next;
                    }
                }
                // edge case当指针指向新链表最后一个node时，如果还没进行过插入，则将待插入node插在最后
                if (currentInner.next == null && currentInner.value <= current.value) {
                    currentInner.next = current;
                }

            }
            current = next;
        }
        return dummyHead.next;
    }
}
// Time: O(n^2)
// Space: O(1)