/**
 * public class TreeNode { public int key; public TreeNode left; public TreeNode
 * right; public TreeNode(int key) { this.key = key; } }
 */
// recursive 实现
public class Solution {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return null;
        }
        if (root.key == key) {
            return root;
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }
}
// 时间复杂度： O(height), 因为每次只走一边
// 空间复杂度： O(height)

// ====================================================
/**
 * public class TreeNode { public int key; public TreeNode left; public TreeNode
 * right; public TreeNode(int key) { this.key = key; } }
 */
// recursive 实现
public class Solution {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here

        TreeNode current = root; // root等于null时，会直接返回current = root = null;
        while (current != null && current.key != key) {
            if (current.key == key) {
                return current;
            } else if (current.key > key) {
                current = current.left;
            } else {
                current = current.right;
            }

        }
        return current;
    }
}

// Time: O(height)
// Space: O(height)