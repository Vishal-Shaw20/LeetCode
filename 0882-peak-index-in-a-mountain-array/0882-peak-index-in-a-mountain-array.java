class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = 0, first = 0, last = arr.length - 1, mid;
        while(first <= last)
        {
            mid = first + (last - first)/2;
            if(arr[mid] < arr[mid + 1])
                first = mid + 1;
            else if(arr[mid] < arr[mid - 1])
                last = mid - 1;
            else
            {
                if(arr[mid] > arr[max])
                    max = mid;
                break;
            }
        }
        return max;
    }
}