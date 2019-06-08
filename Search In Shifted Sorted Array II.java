public class Solution {
    public int search(int[] array, int target) {
      // Write your solution here
      if (array == null || array.length == 0)
        return -1;
      int left = 0, right = array.length - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (array[mid] == target) 
          return mid;
        else if (array[mid] == array[left])                   //左边全重复[333123] 或者左边有翻折[31333] （右边正序）
          left++;                                             //worst case like array = [1,1,1,1,1,1,1,2], target = 2: O(n)
        else if (array[mid] > array[left]) {                  //左边不是全重复 并且左边无翻折（左边正序）
          if (array[mid] >= target && target >= array[left])  //target在左边
            right = mid - 1;
          else                                                //target在右边
            left = mid + 1;
        }else {                                               //array[mid] < array[left] 左边有翻折 （右边正序）
          if (array[mid] <= target && target <= array[right]) //target在右边
            left = mid + 1;
          else
            right = mid - 1;                                  //target在左边
        }
      }
  
      if (0<=left && left <= array.length-1 && array[left] == target)
        return left;
      else if (0<=right && right<=array.length-1 && array[right] == target )
        return right;
      else
        return -1;
    }
  }
  
  