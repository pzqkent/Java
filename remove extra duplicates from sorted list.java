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

//当涉及到链表的头的改变时，需要用到dummyhead
//这道题要仔细考虑不同情况的边界条件；
public class Solution {
    public ListNode removeDup(ListNode head) {
          // Write your solution here
          if (head == null || head.next == null) {
            return head;
          }
          
          ListNode dummyHead = new ListNode(0);
          ListNode current = head;
          ListNode tail = dummyHead;
          while (current != null && current.next != null) {
            ListNode currentInner = current.next;
            if (currentInner.value == current.value) {
              while (currentInner != null && currentInner.value == current.value) {
                currentInner = currentInner.next;
              }
              current = currentInner;
            } else {
              tail.next = current;
              tail = tail.next;
          //tail.next = null;
              current = current.next;
            }
            
           if (current != null) { //此处考虑到原链表最后一个不重复元素不能遍历到的情况
               tail.next = current;
               
           } else {
         tail.next = null; //确保生成的链表最后连着的是null
       }

            
          }
          return dummyHead.next;
          
        }
  

}

