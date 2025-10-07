class Solution {
    public int findPeakElement(int[] nums) 
    {
        int low = 0, high = nums.length - 1;
        if(nums.length == 1 || nums[0] > nums[1])
            return 0;
        else if(nums[high] > nums[high - 1])
            return high;
        low++;
        high--;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1])
                low = mid + 1;
            else if(nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}