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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode ptr = l3;
        Boolean T = true;
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            if(T)
            {
                l3.val = sum(l1,l2);
                carry = l3.val / 10;
                l3.val%= 10;
                l3.next = null;
                T = false;
            }
            else
            {
                ptr.next = new ListNode(carry + sum(l1,l2));
                ptr = ptr.next;
                carry = ptr.val / 10;
                ptr.val%= 10;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry != 0)
            ptr.next = new ListNode(carry);
        return l3;
    }

    public int sum(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2.val;
        else if(l2 == null)
            return l1.val;
        else
            return (l1.val + l2.val);
    }
}