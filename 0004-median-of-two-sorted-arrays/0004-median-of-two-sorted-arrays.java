class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int n = nums1.length + nums2.length;
        int i = (n/2) - 1, j = n/2, count = 0, ptr1 = 0, ptr2 = 0, temp1 = -1, temp2 = -1;
        while(ptr1 < nums1.length && ptr2 < nums2.length)
        {
            if(nums1[ptr1] < nums2[ptr2])
            {
                if(count == i)
                    temp1 = nums1[ptr1];
                if(count == j)
                    temp2 = nums1[ptr1];
                ptr1++;
            }
            else
            {
                if(count == i)
                    temp1 = nums2[ptr2];
                if(count == j)
                    temp2 = nums2[ptr2];
                ptr2++;
            }
            count++;
        }
        while(ptr1 < nums1.length)
        {
            if(count == i)
                temp1 = nums1[ptr1];
            if(count == j)
                temp2 = nums1[ptr1];
            count++;
            ptr1++;
        }
        while(count <= j && ptr2 < nums2.length)
        {
            if(count == i)
                temp1 = nums2[ptr2];
            if(count == j)
                temp2 = nums2[ptr2];
            count++;
            ptr2++;
        }
        if((n % 2) == 0)
            return (((double)temp1 + temp2)/2);
        return temp2;
    }
}