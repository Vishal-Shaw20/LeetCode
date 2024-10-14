class Solution2
{
    public static int findPeakElement(int[] nums)
    {
        int max = 0, first = 0, last = nums.length - 1, mid;
        while(first < last)
        {
            mid = first + (last - first)/2;
            if(nums[mid] > nums[mid + 1])
                last = mid;
            else
                first = mid + 1;
        }
        return first;
    }
}