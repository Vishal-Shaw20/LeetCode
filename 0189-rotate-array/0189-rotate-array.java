class Solution {
    public static void rotate(int[] nums, int k)
    {
        k = k % nums.length;
        int temp, i, j = nums.length - k - 1;
        int m = j + nums.length;
        for(i = 0; i < ((nums.length - k)/2); i++)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j--] = temp;
        }
        j = nums.length - 1;
        for(i = (nums.length - k); i < ((m+1)/2); i++)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j--] = temp;
        }
        i = 0;
        j = nums.length - 1;
        while(i < j)
        {
            temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}