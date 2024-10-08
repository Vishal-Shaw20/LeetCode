class Solution {
    public int maximumPopulation(int[][] logs) {
        int MaxYear= 0, max = logs[0][0], min = logs[0][0], s, year = logs[0][0], k = 0;
        for(int i = 0; i < (logs.length * 2); i++)
        {
            if(logs[k][i%2] > max)
                max = logs[k][i%2];
            if(logs[k][i%2] < min)
                min = logs[k][i%2];
            if(i%2 != 0)
                k++;
        }
        System.out.println(max+ " "+ min);
        for(int j = max; j >= min; j--)
        {
            s = 0;
            for(int i = 0; i < logs.length; i++)
            {
                if((j >= logs[i][0]) && (j < logs[i][1]))
                    s++;
            }
            if(s >= MaxYear)
            {
                MaxYear = s;
                year = j;
            }
        }
        return year;
    }
}