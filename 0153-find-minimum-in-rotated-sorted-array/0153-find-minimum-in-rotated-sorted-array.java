class Solution {
    public int findMin(int[] nums) {
        int first = 0, last = nums.length - 1, mid;
        while(first < last)
        {
            mid = first + (last - first)/2;
            if(nums[mid] > nums[mid + 1])
            {   
                last = mid;
                break;
            }
            if(nums[mid] < nums[first])
                last = mid - 1;
            else
                first = mid + 1;
        }
        if(last == nums.length - 1)
            return nums[0];
        else
            return nums[last + 1];
    }
}