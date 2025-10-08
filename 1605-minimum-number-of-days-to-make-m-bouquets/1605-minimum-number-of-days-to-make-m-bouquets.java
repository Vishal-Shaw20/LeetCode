class Solution {
    public int minDays(int[] bloomDay, int m, int k) 
    {
        if(((long)m * k) > bloomDay.length)
            return -1;
        int low = bloomDay[0], high = bloomDay[0];
        for(int i = 1; i < bloomDay.length; i++)
        {
            high = (high < bloomDay[i])? bloomDay[i] : high;
            low = (low > bloomDay[i])? bloomDay[i] : low;
        }
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int num = check(bloomDay,mid,k);
            if(num >= m)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return low;
    }
    public int check(int[] bloomsDay, int mid, int k)
    {
        int count = 0, max = 0;
        for(int i = 0;i < bloomsDay.length; i++)
        {
            if(bloomsDay[i] <= mid)
                count++;
            else
            {
                max += count / k;
                count = 0;
            }
        }
        return (max + (count / k));
    }
}