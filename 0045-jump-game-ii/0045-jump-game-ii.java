class Solution {
    public int jump(int[] nums) {
        int left = 0, right = 0, jumps = 0;
        while(right < (nums.length - 1))
        {
            int temp = right;
            right = left + nums[left];
            for(int i = left + 1; i <= temp; i++)
                right = Math.max(right, i + nums[i]);
            left = temp + 1;
            jumps++;
        }
        return jumps;
    }
}