/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
      if(n==0) {
          return new LinkedList<TreeNode>();
          
      }
      return generateTrees(1,n);
    
        
    }
    
    public LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        
        for (int i = start; i<=end; i++){
            LinkedList<TreeNode> leftTrees = generateTrees(start,i-1);
            
            LinkedList<TreeNode> rightTrees = generateTrees(i+1,end);
            
            for (TreeNode l: leftTrees){
                for (TreeNode r: rightTrees){
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    allTrees.add(currentTree);
                    
                }
            }
        }
        return allTrees;
    }
}