class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int k = 0;
        int[] target = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(i == index[i])
            target[i] = nums[i];
            else if(index[i] < i)
            {
                for(int j = (i-1); j >= index[i]; j--)
                target[j + 1] = target[j];
                target[index[i]] = nums[i];
                
            }
        }
        return target;
    }
}