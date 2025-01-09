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
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        ListNode[] ptr = lists;
        ListNode root, temp;
        int min = 0, i = 0, k = 0, n = lists.length;
        boolean T = true;
        for(int j = 0; j < n; j++)
        {
            if(lists[j] != null)
            {
                min = lists[j].val;
                break;
            }
            if(j == (n - 1))
                return null;
        }
        root = temp = new ListNode(min);
        while(true)
        {
            for(int m = 0; m < n; m++)
            {
                if(ptr[m] != null)
                {
                    min = lists[m].val;
                    k = m;
                    break;
                }
                if(m == (n - 1))
                    return root;
            }
            for(int m = 0; m < n; m++)
            {
                if (ptr[m] == null)
                    continue;
                if (ptr[m].val < min)
                {
                    k = m;
                    min = ptr[m].val;
                }
            }
            if(T)
            {
                root.val = ptr[k].val;
                ptr[k] = ptr[k].next;
                T = false;
            }
            else
            {
                temp.next = new ListNode(ptr[k].val);
                temp = temp.next;
                ptr[k] = ptr[k].next;
            }
        }
    }
}