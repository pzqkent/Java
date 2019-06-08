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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    if (head == null) {
      return head;
    }
    ListNode smallNode = new ListNode(0);
    ListNode largeNode = new ListNode(0);
    ListNode current = head;
    ListNode smallTail = smallNode;
    ListNode largeTail = largeNode;
    while (current != null) {
      if (current.value < target) {
        smallTail.next = current;
        smallTail = smallTail.next;
      } else {
        largeTail.next = current;
        largeTail = largeTail.next;
      }
      current = current.next;
    }
    smallTail.next = largeNode.next; 
    largeTail.next = null; //注意断掉largeTail.next 以免有循环出现；
    return smallNode.next;
  }
}

