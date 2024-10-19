class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0, j, temp, k = 1;
        while(i < nums.length)
        {
            if(nums[i] < 1 || nums[i] > nums.length)
            {
                i++;
                continue;
            }
            if(nums[i] != (i + 1))
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            if(nums[i] == (i + 1) || nums[i] < 1 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i])
                i++;
        }
        for(j = 0; j < nums.length; j++)
        {
            if(nums[j] < 1)
                continue;
            if(nums[j] != k)
                break;
            k++;
        }
        return k;
    }
}