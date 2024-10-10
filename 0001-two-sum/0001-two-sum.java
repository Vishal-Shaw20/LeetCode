class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int k = 0;
        for(int i = 0; i < (nums.length * nums.length); i++)
        {
            if(k >= (i % nums.length))
            continue;
            if((nums[k] + nums[i%nums.length]) == target)
            {
                indices[0] = i % nums.length;
                indices[1] = k;
                break;
            }
            if((i%nums.length) == (nums.length - 1))
            k++;
        }
        return indices;
    }
}