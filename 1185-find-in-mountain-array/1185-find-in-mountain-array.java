/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int first = 0, last = mountainArr.length() - 1, mid;
        while(first < last)
        {
            mid = first + (last - first)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid + 1))
                last = mid;
            else
                first = mid + 1;
        }
        int ans = BinarySearch(mountainArr,target,0,first,1);
        if(ans != -1)
            return ans;
        return BinarySearch(mountainArr,target,first + 1,mountainArr.length() - 1,2);
    }
    public int BinarySearch(MountainArray mountainArr, int target, int first, int last, int k)
    {
        int mid, ans = -1;
        if(k == 1)
        {
            while (first <= last)
            {
                mid = first + (last - first)/2;
                if (mountainArr.get(mid) > target)
                    last = mid - 1;
                else if (mountainArr.get(mid) < target)
                    first = mid + 1;
                else
                    return mid;
            }
        }
        else
        {
            while (first <= last)
            {
                mid = first + (last - first)/2;
                if (mountainArr.get(mid) < target)
                    last = mid - 1;
                else if (mountainArr.get(mid) > target)
                    first = mid + 1;
                else
                    return mid;
            }
        }
        return ans;
    }
}