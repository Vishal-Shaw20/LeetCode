class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return calc(nums, k) - calc(nums, k - 1);
    }
    public int calc(int[] nums, int k)
    {
        int i = 0, j = 0, oddNum = 0, count = 0;
        while(j < nums.length)
        {
            if((nums[j] & 1) == 1)
                oddNum++;
            while(oddNum > k)
                oddNum = ((nums[i++] & 1) == 1)? oddNum - 1 : oddNum;
            count += j++ - i + 1;
        }
        return count;
    }
}