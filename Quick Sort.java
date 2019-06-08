public class Solution {
  public int[] quickSort(int[] array) {
		    // Write your solution here
		    if (array == null || array.length <= 1) {
		      return array;
		    }else {
		      int left = 0;
		      int right = array.length - 1;
		      sort(array,left,right);
		      return array;
		    }
//time complexity: worst case:O(n^2), average: O(n*logn) 
    /*解释：最坏情况下，每次选取的pivot都是当前array里的最小值，导致需要n次recursion完成排序。
      在每层recursion中，需要O(n)的时间，故总时间复杂度为O(n*n)*/
//space complexity: worst O(n), average: O(log(n))
    /*解释：空间复杂度来自于recursion时的call stack，和最大recursion深度有关。
      最坏情况下，需要进行n次recursion，每层recursion的空间复杂度为O(1),故总空间复杂度为O(n)*/
		  }
		private static void sort(int[] array, int left, int right) {
			if (left >= right) {
				return;
			}
		  if (array == null || array.length <= 1) {
		      return;
		  }
		    int i = 0;
		    int pivot = right;
		    int k = pivot - 1;
		    while (i <= k) {
		      if (array[i] <= array[pivot]) {
		        i++;
		      }else {
		        swap(array,i,k);
		        k--;
		      }
		    
		    }
		    swap(array,i,pivot);
		    sort(array,left,i-1);//如果这里写为sort(array,left,i)会陷入死循环因为在最坏情况下，这样写会导致下次的pivot和这次相等。
		    sort(array,i+1,right);

		  }
		  
		  private static void swap(int[] array, int left, int right) {
		    int temp = array[left];
		    array[left] = array[right];
		    array[right] = temp;
		  }
	
}

