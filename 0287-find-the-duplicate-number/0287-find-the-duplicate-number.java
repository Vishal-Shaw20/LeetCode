class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0, temp;
        while(i < nums.length)
        {
            if(nums[i] != (i + 1))
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            if(nums[nums[i] - 1] == nums[i] && nums[i] != (i + 1))
                break;
            if(nums[i] == (i + 1))
                i++;
        }
        return nums[i];
    }
}