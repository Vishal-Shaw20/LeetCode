class Solution {
    public boolean check(int[] nums) {
        int flag = 0, flag1 = 1;
        for(int i = 0; i < (nums.length - 1); i++)
        {
            if(nums[i] > nums[i + 1] && flag1 == 1)
            {
                flag = 1;
                flag1 = 0;
            }
            if(flag == 0)
                continue;
            else
            {
                if(nums[0] < nums[i + 1])
                    return false;
                if(nums[i] > nums[i + 1] && flag == 2)
                    return false;
                flag = 2;
            }
        }
        return true;
    }
}