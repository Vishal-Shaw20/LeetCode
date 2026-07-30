class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums)
            xor ^= num;
        int setBit = xor & (-xor);
        int xor0 = 0, xor1 = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if((nums[i] & setBit) == 0)
                xor0 ^= nums[i];
            else
                xor1 ^= nums[i];
        }
        return new int[]{xor0, xor1};
    }
}