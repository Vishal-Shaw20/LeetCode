class Solution {
    public void nextPermutation(int[] nums) 
    {
        if(nums.length <= 1)
            return;

        int i = nums.length - 2, k = 1;

        while(nums[i] >= nums[i + 1])
        {
            i--;
            if(i < 0)
                break;
        }

        if(i >= 0)
        {
            int min = i + 1;
            for (int j = (i + 1); j < nums.length; j++)
                min = (nums[j] <= nums[min] && nums[j] > nums[i]) ? j : min;
            swap(nums, i, min);
        }

        for(int m = (i + 1); m < ((nums.length + i + 1)/2); m++)
            swap(nums,m,nums.length - k++);
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}