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
  public ListNode removeElements(ListNode head, int val) {
    // Write your solution here
    if (head == null) {
      return head;
    }
    while (head != null && head.value == val) {
      head = head.next; //处理头节点及其后连续值都等于val的情况；
      }
      
    
    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.next.value == val) {
        ListNode pointer = current;
        while (pointer.next != null && pointer.next.value == val) {
          pointer = pointer.next;  //处理list中有连续node的值等于val的情况；
        }
        current.next = pointer.next;
        current = current.next;
      } else {
        current = current.next;
      }
      
    }
    return head;
  }
}

