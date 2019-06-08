
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
  public ListNode cycleNode(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return null;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }
    if (fast != slow) {
      return null;
    } else {
      ListNode slowNew = head;
      while (slowNew != slow) {
        slowNew = slowNew.next;
        slow = slow.next;
      }
    }
    
    return slow;
    
    /*
    对于不完美环：
    slow pointer: head     ->      环起点     ->      '相遇点'
    fast pointer: head -> 环起点 -> 相遇点 -> 环起点 -> '相遇点'
    所以：
        距离上有：[head -> 环起点 -> 相遇点] == [相遇点 -> 环起点 -> '相遇点']
        等式两边同时减去[环起点 -> 相遇点],
        可得到距离上：[head -> 环起点] == [相遇点 -> 环起点]
    因此，在slow和fast两个指针第一次相遇后，用两个slow指针分别从head和相遇点出发，他们之后第一次
    相遇的地方就是环起点
    */
  }
}

