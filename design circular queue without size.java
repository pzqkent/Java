class MyCircularQueue {
    int head;
    int tail;
    Integer[] array;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        head = 0;
        tail = head + 1;
        array = new Integer[k];

    }

    public boolean enQueue(int value) {
        if (head == tail) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;

    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (head + 1 == tail) {
            return false;
        }
        head = (head + 1) % array.length;
        return true;
    }

    /** Get the front item from the queue. */
    public Integer Front() {

        if ((head + 1) % array.length == tail) {
            return null;
        }
        return array[(head + 1) % array.length];
    }

    /** Get the last item from the queue. */
    public Integer Rear() {
        if ((head + 1) % array.length == tail) {
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
        return (head + 1) % array.length == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return head == tail;
    }
}