public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        HashSet<String> visited = new HashSet<>();
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });
        int row = matrix.length;
        int col = matrix[0].length;
        minHeap.offer(new Cell(matrix[0][0], 0, 0));
        int i = 0;
        Cell current = null;
        while (i < k) {
            current = minHeap.poll();
            if (current.r + 1 < row) {
                if (!visited.contains(pos(current.r + 1, current.c))) {
                    minHeap.offer(new Cell(matrix[current.r + 1][current.c], current.r + 1, current.c));
                    visited.add(pos(current.r + 1, current.c));
                }
            }
            if (current.c + 1 < col) {
                if (!visited.contains(pos(current.r, current.c + 1))) {
                    minHeap.offer(new Cell(matrix[current.r][current.c + 1], current.r, current.c + 1));
                    visited.add(pos(current.r, current.c + 1));
                }
            }
            i++;
        }
        return current.value;

    }

    private String pos(int a, int b) {
        return a + "" + b;
    }
}

class Cell {
    public int value;
    public int r;
    public int c;

    public Cell(int value, int r, int c) {
        this.value = value;
        this.c = c;
        this.r = r;
    }

}