class Solution {
    public static void moveZeroes(int[] nums)
    {
        if(nums.length == 1)
            return;
        int i = 0, j = 1;
        while(j != nums.length)
        {
            if(nums[i] != 0)
            {
                i++;
                j++;
                continue;
            }
            if(nums[j] != 0)
            {
                nums[i++] = nums[j];
                nums[j++] = 0;
            }
            else
                j++;
        }
        return;
    }
}