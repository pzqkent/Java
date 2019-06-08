/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  int maxPath = 0;
  public int diameter(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return 0;
    }
    helper(root);
    return maxPath; 
  }
  //问题是求从一个叶子结点到另一个叶子结点的最长距离，也就说明两个叶子结点会通过一个共同父结点连接起来
  //所以我们可以遍历整颗树，找到所有左子树和右子树都存在的父结点，计算通过该结点的最长路径，然后记录得到全局最长路径
  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    if (root.left != null && root.right != null) {
          maxPath = Math.max(maxPath,getHeight(root.left) + getHeight(root.right) + 1);
    }
    helper(root.right);
  }
  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
  }
}

