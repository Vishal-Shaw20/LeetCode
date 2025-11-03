class Solution {
    public int countGoodNumbers(long n) 
    {
        long evenPos = (n + 1) >> 1;
        long oddPos = n >> 1;
        long fivePower = myPow(5, evenPos, 1_000_000_007);
        long fourPower = myPow(4, oddPos, 1_000_000_007);
        return (int)((fivePower * fourPower) % 1_000_000_007);
    }
    public long myPow(long base, long exp, long mod)
    {
        if(exp == 0)
            return 1;
        long half = myPow(base, exp/2, mod);
        long result = (half * half) % mod;
        if((exp % 2) == 1)
            result = (result * base) % mod;
        return result;
    }
}