class Solution {
    public int largestAltitude(int[] gain) {
        int s = 0, max = 0;
        for(int i = 0; i < gain.length; i++)
        {
            s+= gain[i];
            if(s > max)
            max = s;
        }
        return max;
    }
}