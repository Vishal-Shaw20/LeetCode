class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        for(int i = 0; i < k; i++)
            lsum += cardPoints[i];
        if(k == cardPoints.length)
            return lsum;
        int i = k - 1, j = cardPoints.length - 1, rsum = 0, sum = lsum;
        while(i >= 0)
        {
            lsum -= cardPoints[i--];
            rsum += cardPoints[j--];
            sum = Math.max(sum, lsum + rsum);
        } 
        return sum;
    }
}