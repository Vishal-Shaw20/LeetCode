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
        if(head == null || head.next == null)
            return head;
        ListNode mid = middle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        ListNode leftSorted = sortList(left);
        ListNode rightSorted = sortList(right);
        return merge(leftSorted,rightSorted);
    }

    public ListNode merge(ListNode left, ListNode right)
    {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(left != null && right != null)
        {
            if(left.val < right.val)
            {
                temp.next = left;
                left = left.next;
            }
            else
            {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if(left != null)
            temp.next = left;
        if(right != null)
            temp.next = right;
        return dummyNode.next;
    }

    public ListNode middle(ListNode head)
    {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}