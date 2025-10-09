class Solution {
    public int findKthPositive(int[] arr, int k) 
    {
        if(k < arr[0])
            return k;
        int low = 0, high = arr.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int check = arr[mid] - mid - 1;
            if(check < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return (arr[high] + k - (arr[high] - high - 1));
    }
}