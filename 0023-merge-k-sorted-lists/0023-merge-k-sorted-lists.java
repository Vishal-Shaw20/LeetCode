/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists.length == 0)
            return null;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((n1,n2) -> n1.val - n2.val);
        for(int i = 0; i < lists.length; i++)
        {
            if(lists[i] != null)
                minheap.add(lists[i]);
        }
        while(!minheap.isEmpty())
        {
            temp.next = minheap.poll();
            temp = temp.next;
            if(temp.next != null)
                minheap.add(temp.next);
        }
        return dummyNode.next;
    }
}