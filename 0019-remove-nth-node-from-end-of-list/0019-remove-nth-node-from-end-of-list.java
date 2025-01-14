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
    int i = -1;
    boolean T = false;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        find(head,n);
        if(!T)
            head = head.next;
        return head;
    }

    public ListNode find(ListNode head, int n)
    {
        if(head == null)
        {
            return head;
        }
        find(head.next,n);
        i++;
        if(i == n)
        {
            remove(head);
            T = true;
        }    
        return head;
    }

    public void remove(ListNode head)
    {
        head.next = head.next.next;
    }
}