class MyCircularDeque {
    int head;
    int tail;
    int size;
    Integer[] array;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = 0;
        tail = 0;
        size = 0;
        array = new Integer[k];

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (size == array.length) {
            return false;
        }
        if (head == 0) {
            array[array.length - 1] = value;
            head = array.length - 1;
            size++;
            return true;
        } else {
            array[--head] = value;
            size++;
            return true;
        }

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (size == array.length) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % array.length;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (tail == 0) {
            tail = array.length - 1;
            size--;
            return true;
        } else {
            size--;
            tail--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public Integer getFront() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    /** Get the last item from the deque. */
    public Integer getRear() {
        if (size == 0) {
            return null;
        }
        if (tail == 0) {
            return array[array.length - 1];
        } else {
            return array[tail - 1];
        }

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */