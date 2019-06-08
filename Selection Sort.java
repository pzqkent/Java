public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0)
      return array;
    //int[] result = new int[array.length];
    int i,j,min,temp,index;
    /*int i = 0, j = 0;
    int temp;
    int temp1;
    int index;
    */
    for (i = 0; i < array.length; i++) {
      temp = array[i]; //用于记录原数组第i个值；
      min = array[i]; //用于记录每次循环中最小的值
      index = i; //用于记录每次循环中最小值的位置
      for (j = i; j < array.length; j++) {
        if (array[j] < min) {
          min = array[j];
          index = j;
        }      
      }
      array[i] = min;
      array[index] = temp;
    }
    return array;
      
  }
}

