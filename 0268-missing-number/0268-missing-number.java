class Solution {
    public int missingNumber(int[] nums) {
        int index = 0, temp, i = 0;
        while(i < nums.length)
        {
            if(nums[i] != (i + 1) && nums[i] != 0)
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            if(nums[i] == (i + 1))
                i++;
            else if(nums[i] == 0)
            {
                i++;
                index = i;
            }
        }
        return index;
    }
}