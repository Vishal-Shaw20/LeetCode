class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        long total = 0, low, high;
        for(int i = 0; i < piles.length; i++)
            total += piles[i];
        low = ((total - 1) / h) + 1;
        high = ((total - piles.length) / (h - piles.length + 1)) + 1;
        while(low <= high)
        {
            long mid = (low + high)/2;
            int time = reqTime(piles,mid);
            if(time <= h)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (int)low;
    }
    public static int reqTime(int[] piles, long mid)
    {
        int totalTime = 0;
        for(int i = 0; i < piles.length; i++)
            totalTime += ((piles[i] - 1) / mid) + 1;
        return totalTime;
    }
}