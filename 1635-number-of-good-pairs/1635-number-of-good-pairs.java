class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = 0,j = 1, k = 0,g = 0;
        for(int i = 1; i < nums.length; i++)
        n+= i;
        for(int i = 1; i <= n; i++)
        {
            if(j == nums.length)
            {
                k++;
                j = k + 1;
            }
            if(nums[k] == nums[j])
            g++;
            j++;
        }
        return g;
    }
}