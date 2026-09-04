class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int count = 0, freeTime = Integer.MIN_VALUE;
        for(int[] interval : intervals)
        {
            if(freeTime == Integer.MIN_VALUE || interval[0] >= freeTime)
            {
                freeTime = interval[1];
                count++;
            }
        }
        return (intervals.length - count);
    }
}