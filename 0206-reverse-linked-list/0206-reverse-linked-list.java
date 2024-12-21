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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        // Reverse(head);
        ListNode tail = head;
        tail = Reverse(head,tail);
        head.next = null;
        return tail;
    }

    public ListNode Reverse(ListNode head, ListNode tail)
    {
        if(head.next != null)
            tail = Reverse(head.next,tail.next);
        if(head.next == null)
        {
            return tail;
        }
        head.next.next = head;
        return tail;
    }
}