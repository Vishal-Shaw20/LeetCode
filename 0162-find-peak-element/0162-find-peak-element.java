class Solution {
    public int findPeakElement(int[] nums) {
        int max = 0, first = 0, last = nums.length - 1, mid;
        while(first < last)
        {
            mid = first + (last - first)/2;
            if((mid + 1 == nums.length) || (mid - 1 == -1 && last == 0))
                return mid;
            if(nums[mid] < nums[mid + 1])
            {
                first = mid + 1;
                max = first;
            }
            else if((mid - 1) != -1 && nums[mid] < nums[mid - 1])
                last = mid - 1;
            else
            {
                if(nums[mid] > nums[max])
                    max = mid;
                break;
            }
        }
        return max;
    }
}