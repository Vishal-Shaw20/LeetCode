/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) 
    {
        ListNode fast, slow;
        fast = slow = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
            {
                ListNode temp = head;
                while(temp != fast)
                {
                    temp = temp.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}