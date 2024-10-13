public class Solution2
{
    public static int[] searchRange(int[] nums, int target)
    {
        int [] ans = {-1,-1};
        int first = search(nums,target,true);
        int last = search(nums,target,false);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    public static int search(int[] nums, int target, boolean findStartIndex)
    {
        int ans = -1, first = 0, last = nums.length - 1, mid;
        while (first <= last)
        {
            mid = first + (last - first)/2;
            if (nums[mid] > target)
                last = mid - 1;
            else if (nums[mid] < target)
                first = mid + 1;
            else
            {
                ans = mid;
                if(findStartIndex)
                    last = mid - 1;
                else
                    first = mid + 1;
            }
        }
        return ans;
    }
}
