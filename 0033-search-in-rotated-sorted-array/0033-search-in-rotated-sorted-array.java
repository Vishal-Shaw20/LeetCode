class Solution {
    public int search(int[] nums, int target) {
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
        int ans = -1;
        if(target >= nums[0])
            ans = BinarySearch(nums,target,0,last);
        else if(last < nums.length)
            ans = BinarySearch(nums,target,last + 1,nums.length - 1);
        return ans;
    }
    public static int BinarySearch(int[] nums, int target, int first, int last)
    {
        int mid, ans = -1;
        while (first <= last)
        {
            mid = first + (last - first) / 2;
            if (nums[mid] > target)
                last = mid - 1;
            else if (nums[mid] < target)
                first = mid + 1;
            else
                return mid;
        }
        return ans;
    }
}