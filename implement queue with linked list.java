//用Linked List 实现queue
//尾部插入，头部删除
public class Queue {
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    private ListNode head;
    private ListNode tail;

    public Queue() {
        head = null;
        tail = head;

    }

    public void offer(int element) {
        if (head == null) {
            head = new ListNode(element);
            tail = head;
        } else {
            tail.next = new ListNode(element);
            tail = tail.next;
        }

    }

    public Integer peek() {
        if (head == null) {
            return null;
        } else {
            return head.value;
        }
    }

    public Integer poll() {
        if (head == null) {
            return null;
        } else {
            ListNode result = head;
            head = head.next;
            if (head == null) { // 当head为null时，说明queue里已经没有元素了，我们需要将tail也设置为null；
                tail = null;
            }
            result.next = null;
            return result.value;
        }
    }
}