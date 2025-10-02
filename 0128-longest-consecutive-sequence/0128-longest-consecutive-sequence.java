class Solution {
    public int longestConsecutive(int[] nums) 
    {
        int l = 0, max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        for(int i : set)
        {
            l = 1;
            if(set.contains(i - 1))
                continue;
            else
            {
                while(set.contains(++i))
                    l++;
            }
            max = (l > max)? l : max;
        }
        return max;
    }
}