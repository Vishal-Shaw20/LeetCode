class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSum1 = new int[nums.length];
        int s = 0;
        for(int i = 0; i < nums.length; i++)
        {
            s+= nums[i];
            runningSum1[i] = s;
        }
        return runningSum1;
    }
}