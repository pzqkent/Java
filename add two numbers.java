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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    ListNode currentOne = l1;
    ListNode currentTwo = l2;
    int carry = 0;
    //画个vnn图可以更好的理解currentOne, currentTwo和carry之间的条件关系；
    while (currentOne != null || currentTwo != null || carry == 1) {
      
      if (currentOne != null && currentTwo != null) {
        tail.next = new ListNode((currentOne.value + currentTwo.value + carry) % 10);
        carry = (currentOne.value + currentTwo.value + carry) / 10;
        currentOne = currentOne.next;
        currentTwo = currentTwo.next;
        tail = tail.next;
      } else if (currentOne == null && currentTwo != null) {
        tail.next = new ListNode((currentTwo.value + carry) % 10);
        carry = (currentTwo.value + carry) / 10;
        currentTwo = currentTwo.next;
        tail = tail.next;
      } else if (currentOne != null && currentTwo == null) {
        tail.next = new ListNode((currentOne.value + carry) % 10);
        carry = (currentOne.value + carry) / 10;
        currentOne = currentOne.next;
        tail = tail.next;
      } else {
        tail.next = new ListNode(carry);
        tail = tail.next;
        return dummyHead.next;
      }
      
    
    }
    return dummyHead.next;
  }
}

