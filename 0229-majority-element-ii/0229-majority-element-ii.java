class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max = (nums.length) / 3;
        List<Integer> list = new ArrayList<>();
        if(max == 0)
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(i == 1 && nums[i] == nums[0])
                    continue;
                list.add(nums[i]);
            }
            return list;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                if(map.get(nums[i]) == max)
                    list.add(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else
                map.put(nums[i],1);
        }
        return list;
    }
}