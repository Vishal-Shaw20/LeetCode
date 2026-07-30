class Solution {
    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        int count = 0;
        for(int i = 2; (i * i) < n; i++)
        {
            if(!nums[i])
            {
                for(int j = (i * i); j < n; j += i)
                    nums[j] = true;
            }
        }
        for(int i = 2; i < n; i++)
        {
            if(!nums[i])
                count++;
        }
        return count;
    }
}