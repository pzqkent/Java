class MyCircularQueue {
    int head;
    int tail;
    int size;
    Integer[] array;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        head = 0;
        tail = 0;
        size = 0;
        array = new Integer[k];

    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (size == array.length) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;

    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        size--;
        head = (head + 1) % array.length;
        return true;
    }

    /** Get the front item from the queue. */
    public Integer Front() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    /** Get the last item from the queue. */
    public Integer Rear() {
        if (size == 0) {
            return null;
        }
        if (tail == 0) {
            return array[array.length - 1];
        } else {
            return array[(tail - 1) % array.length];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */