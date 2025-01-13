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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> (a[1] == b[1])? ((a[0] == b[0])? Integer.compare(a[2],b[2]) : Integer.compare(a[0],b[0])) : Integer.compare(a[1],b[1])
        );
        Queue<Object[]> queue = new ArrayDeque<>();
        queue.offer(new Object[]{0,0,root});
        while(!queue.isEmpty())
        {
            Object[] obj = queue.poll();
            TreeNode node = (TreeNode)(obj[2]);
            int row = (int)obj[0];
            int col = (int)obj[1];
            pq.offer(new int[]{row,col,node.val});
            if(node.left != null)
                queue.add(new Object[]{row + 1,col - 1,node.left});
            if(node.right != null)
                queue.add(new Object[]{row + 1,col + 1,node.right});
        }
        Map<Integer,List<Integer>> map = new TreeMap<>();
        while(!pq.isEmpty())
        {
            int[] removed = pq.poll();
            map.putIfAbsent(removed[1], new ArrayList<>());
            map.get(removed[1]).add(removed[2]);
        }
        for(List<Integer> entry : map.values())
            list.add(entry);
        return list;
    }
}