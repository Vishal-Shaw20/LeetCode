class Solution {
    public int reversePairs(int[] nums)
    {
        int count = 0;
        return mergeSort(nums,0,nums.length - 1,count);
    }
    public int mergeSort(int[] nums, int i, int j, int count)
    {
        if(i < j)
        {
            int mid = (i + j) / 2;
            count = mergeSort(nums,i,mid,count);
            count = mergeSort(nums,mid + 1,j,count);
            int a = i, b = mid + 1;
            while(a <= mid && b <= j)
            {
                if(nums[a] > (2 * (long)nums[b]))
                {
                    count += mid - a + 1;
                    b++;
                }
                else
                    a++;
            }
            merge(nums,i,mid,j);
        }
        return count;
    }
    public void merge(int[] nums, int low, int mid, int high)
    {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L = new int[n1], R = new int[n2];
        for(int i = 0; i < n1; i++)
            L[i] = nums[i + low];
        for(int j = 0; j < n2; j++)
            R[j] = nums[j + mid + 1];
        int i = 0, j = 0, k = low;
        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j])
                nums[k++] = L[i++];
            else
                nums[k++] = R[j++];
        }
        while(i < n1)
            nums[k++] = L[i++];
        while(j < n2)
            nums[k++] = R[j++];
    }
}