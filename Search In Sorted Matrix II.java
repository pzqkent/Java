public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here
    /*思路一：先找出符合条件的所有行 worst case: 所有行都满足条件 O(row)
             然后对每一行进行二分查找 O(log_2(col))
             总的时间复杂度 worst case: o(row * log_2(col))
             
      思路二： 从矩阵右上角的值开始，如果该值大于target，则向左移动一格；如果
              该值小于target，则向下移动一格。
              worst case: target 位于矩阵左下角：O(row + col)
      假设row==col==n，则t1 = log_2(n) * n, t2 = 2n;
        n == 2时，t1 == t2;
        1 <= n < 2 时，t1 < t2;
        n > 2时，t1 > t2;
    */
    //思路二
    int pointerRow = 0;
    int pointerCol = matrix[0].length - 1;
    while (pointerRow <= matrix.length - 1 && pointerCol >= 0) {
      if (matrix[pointerRow][pointerCol] == target)
        return new int[]{pointerRow,pointerCol};
      else if (matrix[pointerRow][pointerCol] > target)
        pointerCol--;
      else
        pointerRow++;
    }
    return new int[]{-1,-1};
  
  
  }
  
  
  
  
}

