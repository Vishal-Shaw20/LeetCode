class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return calc(nums, k) - calc(nums, k - 1);
    }
    public int calc(int[] nums, int k)
    {
        int[] map = new int[nums.length + 1];
        if(k == 0)
            return 0;
        int i = 0, j = 0, count = 0, size = 0;
        while(j < nums.length)
        {
            if(map[nums[j]] == 0)
                size++;
            map[nums[j]]++;
            while(size > k)
            {
                if(map[nums[i]] == 1)
                    size--;
                map[nums[i++]]--;
            }
            count += j++ - i + 1;
        }
        return count;
    }
}