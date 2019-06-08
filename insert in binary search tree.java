/**
 * public class TreeNode { public int key; public TreeNode left; public TreeNode
 * right; public TreeNode(int key) { this.key = key; } }
 */
// iterative 做法
public class Solution {
    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode current = root;
        TreeNode prev = root;
        while (current != null) {
            prev = current;
            if (current.key == key) {
                return root;
            }
            if (current.key > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (prev.key > key) {
            prev.left = new TreeNode(key);
        } else {
            prev.right = new TreeNode(key);
        }
        return root;

    }
}
// Time: O(height)
// Space: O(1)

// =========================================================
/**
 * public class TreeNode { public int key; public TreeNode left; public TreeNode
 * right; public TreeNode(int key) { this.key = key; } }
 */
// recursive 实现
public class Solution {
    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return new TreeNode(key);
        }
        if (root.key == key) {
            return root;
        }
        if (root.key > key) {
            root.left = insert(root.left, key);
        } else if (root.key < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }
}
// Time: O(height)
// Space: O(height)