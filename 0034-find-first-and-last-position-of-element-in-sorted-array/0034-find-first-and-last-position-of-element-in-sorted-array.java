class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = 0, last = nums.length - 1, mid, i = -1, j = -1;
        while(first <= last)
        {
            mid = first + (last - first)/2;
            if((double)(nums[mid]) > (target - 0.5))
                last = mid - 1;
            else if((double)(nums[mid]) < (target - 0.5))
                first = mid + 1;
        }
        if(first < nums.length && nums[first] == target)
            i = first;
        first = 0;
        last = nums.length - 1;
        while(first <= last)
        {
            mid = first + (last - first)/2;
            if((double)(nums[mid]) > (target + 0.5))
                last = mid - 1;
            else if((double)(nums[mid]) < (target + 0.5))
                first = mid + 1;
        }
        if(last >= 0 && nums[last] == target)
            j = last;
        return new int[]{i,j};
    }
}