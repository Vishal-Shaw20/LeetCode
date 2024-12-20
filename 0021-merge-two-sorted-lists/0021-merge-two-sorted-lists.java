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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if(list1 == null || list2 == null)
            return ((list1 == null)? list2 : list1);
        if(list1.val <= list2.val)
            return merge(list1,list2);
        else
            return merge(list2,list1);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list2 == null)
            return list1;
        if(list1 == null)
            return list2;
        if(list1.next == null)
        {
            list1.next = merge(list1.next, list2);
            return list1;
        }
        if(list1.val <= list2.val && list1.next.val >= list2.val)
        {
            ListNode temp = list2;
            list2 = list2.next;
            temp.next = list1.next;
            list1.next = temp;
            list1.next = merge(list1.next,list2);
        }
        else
            list1.next = merge(list1.next,list2);
        return list1;
    }
}