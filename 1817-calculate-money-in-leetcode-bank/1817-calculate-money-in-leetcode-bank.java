class Solution {
    public int totalMoney(int n) 
    {
        int d = n / 7, r = n % 7;
        int temp = 0, temp1 = 7, sum = 0;
        for(int i = 0; i < d; i++)
        {
            sum += ((temp1 * (temp1 + 1)) / 2) - ((temp * (temp + 1)) / 2);
            temp++;
            temp1++;
        }
        temp1 = temp + r;
        sum += ((temp1 * (temp1 + 1)) / 2) - ((temp * (temp + 1)) / 2);
        return sum;
    }
}