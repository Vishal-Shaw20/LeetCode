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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode mid = head;
        ListNode temp, temp1 = head;
        while(fast != null && fast.next != null)
        {
            if(fast.next.next == null)
            {
                fast = fast.next;
                break;
            }
            mid = mid.next;
            fast = fast.next.next;
        }
        temp = mid.next;
        mid.next = null;
        ListNode temp2 = Reverse(temp,temp);
        temp.next = null;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.val != temp2.val)
                return false;
            temp1= temp1.next;
            temp2 = temp2.next;
        }
        return true;
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