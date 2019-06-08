public class Solution {
	  public int search(int[] array, int target) {
		    // Write your solution here
		    if (array == null || array.length == 0) {
		      return -1;
		    }
		    int left = 0;
		    int right = array.length - 1;
		    while (left < right - 1) {
		      int mid = left + (right - left) / 2;
		      if (array[mid] == target) {
		        return mid;
		      }
		      if (array[mid] <= array[left]) {
		       //right is ordered
		        if (array[mid] > target) {
		          right = mid - 1;
		        } else {
		          if (target <= array[right]) { // 注意该行写法和下面的相对应
		            left = mid + 1;
		          } else {
		            right = mid - 1;
		          }
		        }
		      } else if (array[mid] > array[left]) {
		        //left is ordered
		        if (array[mid] < target) {
		          left = mid + 1;
		        } else {
            //if (target < array[left]) {
		          if (target >= array[left]) { // 注意这一行的写法
		        	  right = mid - 1;
		          } else {
		        	  left = mid + 1;
		          }
		          }
		        }
		      }
		    
		    if (array[left] == target) {
		      return left;
		    } else if (array[right] == target) {
		      return right;
		    } else {
		      return -1;
		    }
		  }
}

