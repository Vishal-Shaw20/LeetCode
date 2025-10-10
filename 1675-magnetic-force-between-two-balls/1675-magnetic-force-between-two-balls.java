class Solution {
    public int maxDistance(int[] position, int m) 
    {
        int low, high;
        Arrays.sort(position);
        low = 1;
        high = position[position.length - 1] - position[0];
        while(low <= high)
        {
            int mid = low + (high - low)/2, count = 1, lastPosition = position[0];
            for(int i = 1; i < position.length; i++)
            {
                if(count == m)
                    break;
                if((position[i] - lastPosition) >= mid)
                {
                    count++;
                    lastPosition = position[i];
                }
            }
            if(count < m)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }
}