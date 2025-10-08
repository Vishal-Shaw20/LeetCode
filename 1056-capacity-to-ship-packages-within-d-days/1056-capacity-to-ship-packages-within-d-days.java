class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int low = 0, high = 0;
        for(int i = 0; i < weights.length; i++)
        {
            low = (low > weights[i])? low : weights[i];
            high += weights[i];
        }
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(PossibleToShip(weights,mid,days))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public boolean PossibleToShip(int[] weights, int mid, int days)
    {
        int count = 1, max = 0;
        for(int i = 0; i < weights.length; i++)
        {
            if((max + weights[i]) > mid)
            {
                count++;
                max = 0;
            }
            max += weights[i];
            if(count > days)
                return false;
        }
        return (count <= days);
    }
}