public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    
    if (array.length == 0) {
      return array;
    }
    //两个挡板，三个区域
    /*
    [left,i):-1
    [i,j):0
    [j,k):unknow area
    [k,right]:1
    */
    int i = 0;
    int j = 0;
    int k = array.length - 1;
    
    while (j <= k) {
      if (array[j] == -1) {
        swap(array,i,j);
        j++;
        i++;
      }else if(array[j] == 0) {
        j++;
      }else {
        swap(array,j,k);
        k--; 
      }  
    }
    return array;
  }
  private void swap(int[] array, int left, int right) {
    int temp = array[right];
    array[right] = array[left];
    array[left] = temp;
  }
}

