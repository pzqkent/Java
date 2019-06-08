public class Solution {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public Solution() {
        // write your solution here
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            if (stack.peekFirst().equals(minStack.peekFirst())) { // 注意equals的使用
                minStack.pollFirst();
                return stack.pollFirst();
            } else {
                return stack.pollFirst();
            }
        }

    }

    public void push(int element) {
        if (stack.isEmpty()) {
            stack.offerFirst(element);
            minStack.offerFirst(element);
            return;
        }
        if (element <= minStack.peekFirst()) {
            stack.offerFirst(element);
            minStack.offerFirst(element);
        } else if (element > minStack.peekFirst()) {
            stack.offerFirst(element);
        }

    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.peekFirst();
        }

    }

    public int min() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return minStack.peekFirst();
        }

    }
}