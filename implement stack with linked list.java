
// LinkedList 实现stack
// 头部插入，头部删除
class Stack {

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;

        }

    }

    private ListNode head;

    public Stack() {
        head = null;
    }

    public void push(int element) {
        if (head == null) {
            head = new ListNode(element);
        } else {
            // ListNode next = head;
            ListNode newNode = new ListNode(element);
            newNode.next = head;
            head = newNode;

        }
    }

    public Integer pop(ListNode head) {
        if (head != null) {

            ListNode result = head;
            head = head.next;
            result.next = null; // 注意断开result与之后的node的链接
            return result.value;

            // ListNode next = head.next;
            // ListNode result = head;
            // result.next = null;
            // head = next;
            // return result.value;
        } else {
            return null;
        }

    }

    public Integer peek(ListNode head) {
        if (head == null) {
            return null;
        } else {
            return head.value;
        }

    }

}