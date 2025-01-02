/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean T = true;
    public boolean isBalanced(TreeNode root) {
        inorder(root);
        return T;
    }

    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        int BF = Balance_Factor(root);
        if(BF < -1 || BF > 1)
            T = false;
        inorder(root.right);
    }

    public int height(TreeNode root)
    {
        if(root == null)
            return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        return (1 + (Math.max(left_height, right_height)));
    }

    public int Balance_Factor(TreeNode root)
    {
        if(root == null)
            return 0;
        return (height(root.left) - height(root.right));
    }
}