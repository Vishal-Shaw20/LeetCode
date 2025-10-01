class Solution {
    public int maxSubArray(int[] nums)
    {
        int max = nums[0], sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            max = (max < sum)? sum : max;
            sum = (sum < 0)? 0 : sum;
        }
        return max;
    }
}