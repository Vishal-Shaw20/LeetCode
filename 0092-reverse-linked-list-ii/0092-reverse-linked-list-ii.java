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
    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        ListNode Left = head, Right = head, temp1 = null, temp2;
        for(int i = 1; i < left; i++)
        {
            if (i == (left - 1) && left > 1)
                temp1 = Left;
            Left = Left.next;
        }
        for(int i = 1; i < right; i++)
            Right = Right.next;
        temp2 = Right.next;
        if(left > 1)
            temp1.next = null;
        Right.next = null;
        Right = Reverse(Left,Left);
        if(left > 1)
            temp1.next = Right;
        else
            head = Right;
        Left.next = temp2;
        return head;
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