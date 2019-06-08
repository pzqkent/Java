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
  public ListNode rotateKplace(ListNode head, int n) {
    // Write your solution here
    if (head == null || n == 0) {
      return head;
    }
    
    //get the length of the List
    
    int len = 0;
    ListNode current = head;
    
    while (current != null) {
      len++;
      current = current.next;
    }
    
    current = head;
    int shift = n % len;
    if (shift == 0) { //当需要移动的值为0时，直接返回
      return head;
    }
    int i = 0;
    for (i = 0; i < (len - shift) -1; i++) {
      current = current.next;
    }
    ListNode newHead = current.next;
    current.next = null;//断开链接
    current = newHead;
    
    for (int j = 0; j < shift - 1; j++) {
      current = current.next;//找到末尾节点，其实可以和找list长度的过程合并
    }
    current.next = head;
    return newHead;
  }
}

