class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        int subsets = 1 << nums.length;
        for(int i = 1; i < subsets; i++)
        {
            List<Integer> tempList = new ArrayList<>();
            for(int j = 0; j < nums.length; j++)
            {
                if(((i & (1 << j)) >> j) == 1)
                    tempList.add(nums[nums.length - 1 - j]);
            }
            list.add(tempList);
        }
        return list;
    }
}