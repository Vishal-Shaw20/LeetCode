class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int unique = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == unique)
                continue;
            else
            {
                int temp = nums[++k];
                nums[k] = nums[i];
                unique = nums[i];
            }
        }
        return k+1;
    }
}