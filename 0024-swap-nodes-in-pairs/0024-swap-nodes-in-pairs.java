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
    public ListNode swapPairs(ListNode head) {
        ListNode ptr1 = head;
        ListNode temp = head;
        if(head == null)
            return head;
        ListNode ptr2 = head.next;
        while(ptr1 != null && ptr2 != null)
        {
            if(ptr1 == head)
            {
                head = ptr2;
            }
            else
            {
                temp.next = ptr2;
            }
            ptr1.next = ptr2.next;
            ptr2.next = ptr1;
            if(ptr1.next == null || ptr1.next.next == null)
                break;
            temp = ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr1.next;
        }
        return head;
    }
}