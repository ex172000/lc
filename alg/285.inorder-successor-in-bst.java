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
    TreeNode node;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p, null);
        return node;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode higher) {
        if (root == null) return;
        if (root.left == p) {
            node = root;
            return;
        }
        if (root == p) {
            if (higher == null)
                node = p.right;
            return;
        }
        helper(root.left, p, root);
        helper(root.right, p, higher);
    }
}
