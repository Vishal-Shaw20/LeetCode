class Solution {
    public int maxProfit(int[] prices) 
    {
        int maxProfit = 0, minPrice = prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            minPrice = (minPrice > prices[i - 1])? prices[i - 1] : minPrice;
            maxProfit = ((prices[i] - minPrice) > maxProfit)? (prices[i] - minPrice) : maxProfit;
        }
        return maxProfit;
    }
}