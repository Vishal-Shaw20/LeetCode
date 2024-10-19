class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, temp;
        while(i < nums.length)
        {
            if(nums[i] != (i + 1))
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            if(nums[i] == (i + 1) || nums[nums[i] - 1] == nums[i])
                i++;
        }
        for(i = 0; i < nums.length; i++)
        {
            if(nums[i] != (i + 1))
                list.add(nums[i]);
        }
        return list;
    }
}