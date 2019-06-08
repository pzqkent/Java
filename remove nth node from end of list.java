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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Write your solution here
    
    if (head == null || n == 0) {
      return head;
    }
    
    ListNode current = head;
    ListNode fast = head; //当过完一遍list后，fast会停在最后一个node的位置，current 停在要删除的node的前一个位置
    
    for (int i = 0; i < n; i++) {
      if (fast == null) { //考虑n小于list长度的情况
        return head;
      } else {
        fast = fast.next;
      }
    }
    if (fast == null) {
      return head.next; //考虑n等于list长度的情况
    }
    while (fast.next != null) {
      fast = fast.next;
      current = current.next;
    }
    
    ListNode temp = current.next.next;
    current.next = temp;
    return head;
   
  }
}

