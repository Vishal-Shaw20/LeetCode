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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return buildBSTBalance(list,0,list.size() - 1);
    }

    public void inorder(TreeNode root, List<Integer> list)
    {
        if(root == null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);    
    }

    public TreeNode buildBSTBalance(List<Integer> list, int start, int end)
    {
        if(start > end)
            return null;
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBSTBalance(list,start,mid - 1);
        root.right = buildBSTBalance(list,mid + 1,end);
        return root;
    }
}