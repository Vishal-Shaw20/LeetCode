class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return calc(nums, goal) - calc(nums, goal - 1);
    }
    public int calc(int[] nums, int goal)
    {
        if(goal < 0)
            return 0;
        int i = 0, j = 0, count = 0, sum = 0;
        while(j < nums.length)
        {
            sum += nums[j];
            while(sum > goal)
                sum -= nums[i++];
            count += j++ - i + 1;
        }
        return count;
    }
}