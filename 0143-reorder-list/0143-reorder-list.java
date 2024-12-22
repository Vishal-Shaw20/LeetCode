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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode fast = head, slow = head, temp = head;
        while(fast != null && fast.next != null)
        {
            if(fast.next.next == null)
            {
                fast = fast.next;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != null)
            temp = slow.next;
        fast = Reverse(temp,temp);
        slow.next = fast;
        if(temp != null)
            temp.next = null;
        temp = head;
        while(fast != null)
        {
            if(temp == fast || temp.next == fast)
                return;
            slow.next = fast.next;
            fast.next = temp.next;
            temp.next = fast;
            fast = slow.next;
            temp = temp.next.next;
        }
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