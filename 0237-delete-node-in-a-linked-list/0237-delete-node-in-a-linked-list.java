/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode ptr = node;
        while(ptr.next.next != null)
        {
            ptr.val = ptr.next.val;
            ptr = ptr.next;
        }
        ptr.val = ptr.next.val;
        ptr.next = null;
    }
}