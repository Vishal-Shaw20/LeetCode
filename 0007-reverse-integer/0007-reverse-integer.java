class Solution {
    public int reverse(int x) {
        long n = (long)(Math.log10(Math.abs((long)x)));
        long a;
        if(x > 0)
            a = reverse(x,n);
        else
            a = (reverse(Math.abs(x),n) * (-1));
        if(check(a))
            return (int)a;
        else
            return 0;
    }

    public long reverse(int x, long n)
    {
        if(x == 0)
            return 0;
        return (((long) (x % 10) * (int)(Math.pow(10,n))) + reverse((x / 10),(n - 1)));
    }

    public boolean check(long x)
    {
        long min = -(1L << 31);
        long max = (1L << 31) - 1;
        return (x >= min && x <= max);
    }
}