class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0, j, temp;
        while(i < nums.length)
        {
            if(nums[i] != (i + 1))
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            if(nums[i] == (i + 1) || nums[nums[i] - 1] == nums[i])
                i++;
        }
        for(j = 0; j < nums.length; j++)
        {
            if(nums[j] != (j + 1))
                break;
        }
        return new int[]{nums[j],(j + 1)};
    }
}