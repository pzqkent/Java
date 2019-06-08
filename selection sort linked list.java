/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
/*Thought: 1.need to add a dummyNode to the original linked list before start looping
           in order to deal with the potential problem of 'head change'
           2. use another dummyHead as the start of the sorted linked list
*/
public class Solution {
    public ListNode selectionSort(ListNode head) {
          // Write your solution here
          //Time: O(n^2)
          //Space: O(1)
          if (head == null || head.next == null) {
            return head;
          }
          ListNode newHead = new ListNode(0);
          newHead.next = head;
          ListNode dummyHead = new ListNode(0);
          ListNode tail = dummyHead;
          ListNode current = newHead;
          ListNode minNodePrev = null;
 
          while (newHead != null && newHead.next != null) {
            current = newHead;
            int min = Integer.MAX_VALUE;
            while (current != null && current.next != null) {
              if (current.next.value < min) {
                min = current.next.value;
                minNodePrev = current;
              } 
              current = current.next;  
            }
            ListNode minNode = minNodePrev.next;
            minNodePrev.next = minNode.next;
            //minNode.next = null;
            tail.next = minNode;
            tail = tail.next;
            }
          tail.next = null;//其实这句话可以不加，因为在进行最后一次排序时，在原链表中，最后一个元素.next已经等于null了
          return dummyHead.next;
          }
}


