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
    public ListNode sortList(ListNode head) {
        if(head == null)
            return head;
        ListNode tail = head;
        while(tail.next != null)
            tail = tail.next;
        mergesort(head,head,tail);
        return head;
    }

    public void mergesort(ListNode head, ListNode start, ListNode tail)
    {
        if(start != tail)
        {
            ListNode mid = middle(start,tail);
            mergesort(head,start,mid);
            mergesort(head,mid.next,tail);
            merge(head,start,mid,tail);
        }
    }

    public void merge(ListNode head, ListNode start, ListNode mid, ListNode tail)
    {
        ListNode L = null;
        ListNode R = null;
        ListNode L1 = L;
        ListNode R1 = R;
        ListNode temp = start;
        while(temp != mid.next)
        {
            ListNode temp1 = new ListNode();
            temp1.val = temp.val;
            if(L == null)
                L = L1 = temp1;
            else
            {
                L1.next = temp1;
                L1 = L1.next;
            }
            temp = temp.next;
        }
        while(temp != tail.next)
        {
            ListNode temp1 = new ListNode();
            temp1.val = temp.val;
            if(R == null)
                R = R1 = temp1;
            else
            {
                R1.next = temp1;
                R1 = R1.next;
            }
            temp = temp.next;
        }
        L1 = L;
        R1 = R;
        temp = start;
        while(L1 != null && R1 != null)
        {
            if(L1.val <= R1.val)
            {
                temp.val = L1.val;
                L1 = L1.next;
            }
            else
            {
                temp.val = R1.val;
                R1 = R1.next;
            }
            temp = temp.next;
        }
        while(L1 != null)
        {
            temp.val = L1.val;
            L1 = L1.next;
            temp = temp.next;
        }
        while(R1 != null)
        {
            temp.val = R1.val;
            R1 = R1.next;
            temp = temp.next;
        }
    }

    public ListNode middle(ListNode head, ListNode tail)
    {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail.next && fast.next != tail.next)
        {
            fast = fast.next.next;
            if(fast != tail.next)
                slow = slow.next;
        }
        return slow;
    }
}