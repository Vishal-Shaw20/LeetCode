class Solution {
    public int candy(int[] ratings) {
        int i = 1, sum = 1, n = ratings.length, peak, down;
        while(i < n)
        {
            while(i < n && ratings[i] == ratings[i - 1])
            {
                sum++;
                i++;
            }
            peak = 1;
            while(i < n && ratings[i] > ratings[i - 1])
            {
                peak++;
                sum += peak;
                i++;
            }
            down = 1;
            while(i < n && ratings[i] < ratings[i - 1])
            {
                down++;
                sum += down - 1;
                i++;
            }
            if(down > peak)
                sum += down - peak;
        }
        return sum;
    }
}