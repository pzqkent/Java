//array实现stack
//array尾部实现插入和删除操作
public class BoundedStack {
    int head;
    int size;
    int array[];

    public Stack(cap){
        array = new Integer[cap];
        head = -1;
        size = 0;
    }

    public Boolean push(int element) {
        if (head == array.length - 1) {
            return false;
        }
        array[head + 1] = element;
        size++;
        head = head + 1;
        return ture;
    }

    public Integer top() {
        if (head == -1) {
            return null;
        }
        return array[head];

    }

    public Integer pop() {
        if (head == -1) {
            return null;
        }
        int result = array[head];
        head = head - 1;
        size--;
        return result;

    }
}