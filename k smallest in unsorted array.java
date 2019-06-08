public class Solution {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        // PriorityQueue<Integer> maxHeap = new
        // PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return -num1.compareTo(num2);
            }
        });
        for (int num : array) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else {
                if (num < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(num);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            result[k - i - 1] = maxHeap.poll();
        }
        return result;
    }
}
// Time: O(k + (n-k) * log(k))
// Space: O(k)