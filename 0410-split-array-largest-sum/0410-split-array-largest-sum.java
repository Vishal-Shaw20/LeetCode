class Solution {
    public int splitArray(int[] nums, int k) 
    {
        if(nums.length < k)
            return -1;
        int low = Integer.MIN_VALUE, high = 0;
        for(int i = 0; i < nums.length; i++)
        {
            low = (low > nums[i])? low : nums[i];
            high += nums[i];
        }
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(check(nums,mid) <= k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public static int check(int[] nums, int mid)
    {
        int k = 1, sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if((sum + nums[i]) > mid)
            {
                k++;
                sum = 0;
            }
            sum += nums[i];
        }
        return k;
    }
}