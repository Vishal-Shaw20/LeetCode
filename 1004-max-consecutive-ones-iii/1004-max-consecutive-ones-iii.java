class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, maxLen = 0;
        while(j < nums.length)
        {
            if(nums[j] == 1 || (nums[j] == 0 && k > 0))
            {
                if(nums[j] == 0)
                    k--;
            }
            else
            {
                while(nums[i] != 0)
                    i++;
                i++;
            }
            j++;
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}