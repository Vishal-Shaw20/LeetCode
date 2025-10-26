/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode tempA = headA, tempB = headB;
        int temp1 = 1, temp2 = 2;
        while(tempA != tempB)
        {
            if(tempA.next == null && tempB.next == null)
                return null;
            if(tempA.next == null)
            {
                if(temp1 == 1)
                {
                    tempA = headB;
                    temp1 = 2;
                }
                else
                {
                    tempA = headA;
                    temp1 = 1;
                }
                tempB = tempB.next;
            }
            else if(tempB.next == null)
            {
                if(temp2 == 1)
                {
                    tempB = headB;
                    temp2 = 2;
                }
                else
                {
                    tempB = headA;
                    temp2 = 1;
                }
                tempA = tempA.next;
            }
            else
            {
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        return tempA;
    }
}