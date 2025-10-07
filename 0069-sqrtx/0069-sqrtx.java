class Solution {
    public int mySqrt(int x) 
    {
        if(x == 0)
            return 0;
        long low = 1, high = x;
        boolean flag = false;
        while(low <= high)
        {
            long mid = (low + high)/2;
            long num = (long)mid * mid;
            if(num == x)
                return (int)mid;
            else if((high - low) == 1 || low == mid)
                return (int)low;
            else if(num > x)
            {
                high = mid;
            }
            else
                low = mid;
        }
        return (int)low;
    }
}