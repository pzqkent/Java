public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    /*if (b == 0)
      return 1;
    else
      return a * power(a,b-1); O(n)
      */
    
    if (b == 0)
      return 1;
    if (a == 0)
      return 0;
    long half = power(a, b / 2);
    return (b % 2 == 0) ? half * half : half * half * a;  
  }
} //O(log(b))


