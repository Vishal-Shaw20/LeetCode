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
    int max = 0;
    public int maxDepth(TreeNode root) {
        count(root,0);
        return max;
    }

    public void count(TreeNode root, int n)
    {
        if(root == null)
        {
            if(max < n)
                max = n;
            return;
        }
        count(root.left,(n + 1));
        count(root.right,(n + 1));
    }
}