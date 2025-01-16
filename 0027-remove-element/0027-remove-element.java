class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, count = 0;
        while(i != nums.length)
        {
            if(nums[i] != val)
            {
                nums[count] = nums[i];
                count++;
            }    
            i++;
        }
        for(i = count; i < nums.length; i++)
            nums[i] = 0;
        return count;
    }
}