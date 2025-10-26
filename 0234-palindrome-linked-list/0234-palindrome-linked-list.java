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
        ListNode slow = head;
        ListNode temp, temp1 = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        temp = slow;
        ListNode prev = null, front = null;
        while(temp != null)
        {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        while(temp1 != null && prev != null)
        {
            if(temp1.val != prev.val)
                return false;
            temp1= temp1.next;
            prev = prev.next;
        }
        return true;
    }
}