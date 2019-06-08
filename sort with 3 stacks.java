
public class Solution {
    public void sort(LinkedList<Integer> s1) {
          LinkedList<Integer> s2 = new LinkedList<Integer>();
          LinkedList<Integer> s3 = new LinkedList<Integer>();
          // Write your solution here.
          
          
          while (!s1.isEmpty() || !s2.isEmpty()) {
            int globalMin = Integer.MAX_VALUE;
            int counter = 0;
            while (!s1.isEmpty()) {
              if (s1.peek() < globalMin) {
                globalMin = s1.peek();
                counter = 1;
              } else if (s1.peek() == globalMin) {
                  counter++;
              }
                s2.push(s1.pop());
            }
          
            for (int i = 0; i < counter; i++) {
              s3.push(globalMin);
            }
          
            while (!s2.isEmpty()) {
              if (s2.peek() == globalMin) {
                s2.pop();
              } else {
                s1.push(s2.pop());
              }
            }
          }
          while (!s3.isEmpty()) {
            s1.push(s3.pop());
          }

        }
}
//时间复杂度：原理类似selection sort，故为O(n^2);
//空间复杂度：O(1); 为什么不是O(n)?