class Solution {
     public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(list, 0, new ArrayList<>(), nums);
        return list;
    }
    public void generateSubsets(List<List<Integer>> list, int ind, List<Integer> tempList, int[] nums)
    {
        list.add(new ArrayList<>(tempList));
        for(int i = ind; i < nums.length; i++)
        {
            if(i > ind && nums[i] == nums[i - 1])
                continue;
            tempList.add(nums[i]);
            generateSubsets(list, i + 1, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}