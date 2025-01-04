class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int i = 0, k = 0, s = 0;
        int[] arr = new int[nums.length];
        for(int j = 1; j <= ((nums.length * nums.length)+1); j++)
        {
            if(i == k)
            {
                k++;
                continue;
            }
            if(k == nums.length)
            {
                arr[i] = s;
                i++;
                k = s = 0;
                if(i != nums.length)
                j-=1;
                continue;
            }
            if(nums[i] > nums[k])
            {
                s++;
                k++;
            }
            else
            k++;
        }
        return arr;
    }
}