class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
        long total = 0;
        for(int i = 0; i < nums.length; i++)
            total += nums[i];
        long low = ((total - 1) / threshold) + 1;
        long high = ((total - nums.length) / (threshold - nums.length + 1)) + 1;
        while(low <= high)
        {
            long mid = low + (high - low)/2;
            int sum = calculateSum(nums,mid);
            if(sum <= threshold)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (int)low;
    }
    public int calculateSum(int[] nums, long mid)
    {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += ((nums[i] - 1) / mid) + 1;
        return sum;
    }
}