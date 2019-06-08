/**
 * public class TreeNode { public int key; public TreeNode left; public TreeNode
 * right; public TreeNode(int key) { this.key = key; } }
 */

/*
 * 1.prev == null, go down -> left, right, parent; 2.prev == parent nodes, go
 * down -> left, right, parent; 3.prev == current.left, go current.right; 4.prev
 * == current.right, add current.value to the result list, pop current node out
 */
public class Solution {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peekFirst();// 这句话可以获得每次要访问的node，避免在后面每次都对current进行更新
            if (prev == null || current == prev.left || current == prev.right) {
                if (current.left != null) {
                    stack.offerFirst(current.left);
                    prev = current;
                } else if (current.right != null) {
                    stack.offerFirst(current.right);
                    prev = current;
                } else {
                    result.add(stack.pollFirst().key);
                    prev = current;
                }
            } else if (prev == current.left) {
                if (current.right != null) {
                    stack.offerFirst(current.right);
                    prev = current;
                } else {
                    result.add(stack.pollFirst().key);
                    prev = current;
                }
            } else {
                result.add(stack.pollFirst().key);
                prev = current;
            }
        }
        return result;
    }
}
