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
public class Solution {
    public ListNode reorder(ListNode head) {
      // Write your solution here
      if (head == null || head.next == null) {
        return head;
      }
      ListNode slow = head;
      ListNode fast = head;
      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      if (fast.next == null) {
        ListNode right = slow;
      //} else if (fast.next.next == null) {
      } else {
        ListNode right = slow.next;
      }
      ListNode right = slow.next; //此处right不能等于slow，当right=slow且linkedlist长度为奇数时，左右最后一个元素在右边反转后会重复。
      slow.next = null; //记得断开链接；
      ListNode left = head;
  
      right = reverse(right); 
      
      ListNode dummyNode = new ListNode(0);
      ListNode tail = dummyNode;
      
      while (right != null) {
        tail.next = left;   //注意此处赋值时的顺序，要确保tail移动时，left和right已经移动过了
        left = left.next;
        tail.next.next = right;
        right = right.next;
        tail = tail.next.next;
      } 
      if (left != null) {
        tail.next = left; //此处处理当链表长度为奇数时，左边比右边多一个元素的情况
      }
      return dummyNode.next; 
  
    }
    
    private ListNode reverse(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode current = head;
      ListNode prev = null;
      while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }
      return prev;
    }
  }
  
  