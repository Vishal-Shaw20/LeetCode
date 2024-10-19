class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp, i = 0;
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
            if((i + 1) != nums[i])
                list.add(i + 1);
        }
        return list;
    }
}