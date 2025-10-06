class Solution {
    public int findMin(int[] nums) 
    {
        int low = 0, high = nums.length - 1, mid = -1;
        while(low <= high)
        {
            mid = (low + high) / 2;
            if(nums[low] <= nums[mid] && nums[mid] <= nums[high])
                return nums[low];
            else if(nums[mid] <= nums[high])
                high = (high == mid)? (mid - 1) : mid;
            else
                low = (low == mid)? (mid + 1) : mid;
        }
        return nums[mid];
    }
}