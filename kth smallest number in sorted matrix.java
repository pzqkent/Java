public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] a, Integer[] b) {
                if (a[0] == b[0]) {
                    return 0;
                }
                return a[0] < b[0] ? -1 : 1;
            }
        });
        minHeap.offer(new Integer[] { matrix[0][0], 0, 0 });

        int r = 0;
        int c = 0;
        int[][] visited = new int[row][col];
        visited[0][0] = 1;
        int currentValue = matrix[0][0];
        while (i < k) {
            Integer[] current = minHeap.poll();
            currentValue = current[0];
            r = current[1];
            c = current[2];
            // visited[r][c] = 1;
            if (c + 1 < col) {
                if (visited[r][c + 1] != 1) {
                    minHeap.offer(new Integer[] { matrix[r][c + 1], r, c + 1 });
                    visited[r][c + 1] = 1;
                }
            }
            if (r + 1 < row) {
                if (visited[r + 1][c] != 1) {
                    minHeap.offer(new Integer[] { matrix[r + 1][c], r + 1, c });
                    visited[r + 1][c] = 1;
                }
            }
            i++;
        }
        return currentValue;
    }
}
// Time: O(k*log(k))--iterate k times, every iteration needs O(log(k)) for
// offer() methods
// Space: O(k * 3)--minHeap(每一步generate两个，expand一个) + O(row * col)--matrix save
// visited