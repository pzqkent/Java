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
  public ListNode middleNode(ListNode head) {
    // Write your solution here
    if (head == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) { //保证不管listnode的长度是奇数还是偶数，slow及其前面部分的长度总是大于等于slow后面的部分
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}

