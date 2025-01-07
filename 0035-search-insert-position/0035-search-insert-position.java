class Solution {
    public int searchInsert(int[] nums, int target) {
        int first = 0, last = nums.length - 1, mid = 0;
        while(first <= last)
        {
            mid = first + ((last - first) >> 1);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                first = mid + 1;
            else
                last = mid - 1;
        }
        if(nums[mid] > target)
            return mid;
        else
            return (mid + 1);
    }
}