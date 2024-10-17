class Solution {
    public int splitArray(int[] nums, int k) {
        int p = 0, last = 0, first = nums[0], mid, s, c;
        for(int i = 0; i < nums.length; i++)
        {
            last+= nums[i];
            if(first < nums[i])
                first = nums[i];
        }
        while(first < last)
        {
            c = s = 0;
            mid = first + (last - first)/2;
            for(int i = 0; i < nums.length; i++)
            {
                s+= nums[i];
                if(s > mid)
                {
                    c++;
                    s = nums[i];
                }
            }
            c++;
            if(c <= k)
                last = mid;
            else
                first = mid + 1;
        }
        return first;
    }
}