class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor)
            return 1;
        else if (dividend == 0)
            return 0;
        long sum = 0;
        boolean sign = true;
        if(dividend >= 0 && divisor < 0)
            sign = false;
        else if(dividend < 0 && divisor > 0)
            sign = false;
        long a = Math.abs((long)(dividend));
        long b = Math.abs((long)(divisor));
        while(a >= b)
        {
            int count = 0;
            while((b << (count + 1)) <= a)
                count++;
            sum += 1L << count;
            a -= b << count;
        }
        if(sum >= ((long)(Integer.MAX_VALUE) + 1))
        {
            if(sign)
                return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
        else if(sign)
            return (int)sum;
        return (int)(~sum + 1);
    }
}