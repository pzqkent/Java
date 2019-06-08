//用array实现queue
//array尾部进入，头部出
public class BoundedQueue {
    int head;
    int tail;
    int size;
    Integer[] array;

    public BoundedQueue(int cap) {
        array = new Integer[cap];
        head = 0;
        tail = head + 1; // tail = head + 1这样可以不用size就判断出queue当前是满或者是空
        size = 0;
    }

    public int poll() {
        if (head + 1 == tail) {
            return null;
        } else {
            int result = head + 1;
            head = head + 1 == array.length ? 0 : head; // 不能写head++，会导致溢出；
            return array[result];
        }

    }

    public Boolean offer(int element) {
        if (head == tail) {
            return false;
        } else {
            array[tail] = element;
            tail = (tail + 1) % array.length;
            return true;
        }
    }
}