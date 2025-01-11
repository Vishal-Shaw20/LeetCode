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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        int i = 0;
        if(root == null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            list.add(new ArrayList<>());
            for(int j = 0; j < size; j++)
            {
                TreeNode current = queue.poll();
                if(current.left != null)
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
                list.get(i).add(current.val);
            }
            i++;
        }
        return reverse(list);
    }

    public List<List<Integer>> reverse(List<List<Integer>> list)
    {
        int size = list.size();
        for(int i = 0; i < (size / 2); i++)
        {
            List<Integer> temp = list.get(i);
            list.set(i,list.get(size - i - 1));
            list.set((size - i - 1),temp);
        }
        return list;
    }
}