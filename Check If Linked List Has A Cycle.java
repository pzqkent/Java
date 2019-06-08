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
  public boolean hasCycle(ListNode head) {
    // write your solution here
    if (head == null || head.next == null){
      return false;
    }
    ListNode current = head;
    ListNode nextNode = head.next;
    while (nextNode != null) {
      if (current == nextNode) {
        return true;
      }else{
        current = current.next;
        if (nextNode.next == null) {
          return false;
        }else {
          nextNode = nextNode.next.next;
        }
      }
    }
    return false;
  }
}