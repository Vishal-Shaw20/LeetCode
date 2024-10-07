class Solution {
    public int findNumbers(int[] nums) {
        int s = 0, c = 0;
        for(int i = 0; i < nums.length; i++)
        {
            s = 0;
            while(nums[i] != 0)
            {
                s++;
                nums[i]/=10;
            }
            if(s%2 == 0)
            c++;
        }
        return c;
    }
}