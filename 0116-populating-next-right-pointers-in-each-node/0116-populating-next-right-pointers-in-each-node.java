/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Node current = queue.peek();;
            for(int i = 0; i < size; i++)
            {
                current = queue.poll();
                if(current.left != null)
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
                current.next = queue.peek();
            }
            current.next = null;
        }
        return root;
    }
}