public class Solution {
    public int search(int[] array, int target) {
      // Write your solution here
      int left = 0;
      int right = array.length - 1;
      while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] == target)
          return mid;
        if (array[mid] == array[left]) { //最大值在左边 右边降序
          if (array[mid] < target)
            right = mid - 1;
          else
            left = mid + 1;
          
        }
        else if (array[mid] > array[left] ) { //最大值在右边[1,2,3,4,-1] 或者最大值在左边[1,3,4,2,1,0,-1]
          //left++;
          if (array[left] == target)
            return left;
          else 
            left++;
            
          if (array[right] == target)
            return right;
          else 
            right--;
        }
        else { // array[mid] < array[left] 最大值在左边 右边降序
          if (array[mid] < target)
            right = mid - 1;
          else 
            left = mid + 1;
          
        }
      
      }
      if (0<=left && left<=array.length-1 && array[left] == target)
        return left;
      else if (0<=right && right<=array.length-1 && array[right] == target)
        return right;
      else 
        return -1;
        //return -1;
    }
    
  }
  
  