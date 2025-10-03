class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        List<Integer> list = new ArrayList<>();
        int count1 = 0, count2 = 0, el1 = 0, el2 = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(count1 == 0 && nums[i] != el2)
            {
                el1 = nums[i];
                count1++;
            }
            else if(count2 == 0 && nums[i] != el1)
            {
                el2 = nums[i];
                count2++;
            }
            else if(nums[i] == el1)
                count1++;
            else if(nums[i] == el2)
                count2++;
            else
            {
                count1--;
                count2--;
            }
        }
        int c1 = 0, c2 = 0, max = (nums.length/3);
        if(el1 > el2)
        {
            el1 = el1 ^ el2;
            el2 = el1 ^ el2;
            el1 = el1 ^ el2;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == el1)
                c1++;
            else if(nums[i] == el2)
                c2++;
        }
        if(c1 > max)
            list.add(el1);
        if(c2 > max)
            list.add(el2);
        return list;
    }
}