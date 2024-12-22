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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null)
            return head;
        ListNode temp = head, temp1 = head;
        int n = 0;
        while(true)
        {
            if(temp.next == null)
            {
                n++;
                break;
            }
            n++;
            temp = temp.next;
        }
        k = k % n;
        for(int i = 1; i < (n - k); i++)
            temp1 = temp1.next;
        temp.next = head;
        head = temp1.next;
        temp1.next = null;
        return head;
    }
}