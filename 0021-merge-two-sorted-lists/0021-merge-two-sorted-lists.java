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
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        ListNode list3 = null, temp = null;
        while(list1 != null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
                if(list3 == null)
                    list3 = temp = list1;
                else
                {
                    temp.next = list1;
                    temp = temp.next;
                }
                list1 = list1.next;
            }
            else
            {
                if(list3 == null)
                    list3 = temp = list2;
                else
                {
                    temp.next = list2;
                    temp = temp.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 != null)
            temp.next = list1;
        else 
            temp.next = list2;
        return list3;
    }
}