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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int n = 1, c = 1;
        ListNode temp = head, temp1 = head, temp2, ptr = head, prevEnd = head;
        while(ptr != null)
        {
            if(n < k && ptr.next == null)
                return head;
            else if(n < k)
            {
                n++;
                temp1 = temp1.next;
            }
            else if(n == k)
            {
                n = 1;
                temp2 = temp1.next;
                temp1.next = null;
                temp1 = Reverse(temp,temp);
                temp.next = temp2;
                if(c == 1)
                {
                    head = temp1;
                    c = 0;
                }
                else
                {
                    prevEnd.next = temp1;
                    prevEnd = temp;
                }
                temp = temp1 = ptr = temp2;
                continue;
            }
            ptr = ptr.next;
        }
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