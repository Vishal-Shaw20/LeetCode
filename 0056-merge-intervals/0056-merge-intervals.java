class Solution {
    public int[][] merge(int[][] intervals) 
    {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        int[] arr = {intervals[0][0], intervals[0][1]};
        for(int i = 1; i < intervals.length; i++)
        {
            if(arr[1] >= intervals[i][0])
                arr[1] = (arr[1] > intervals[i][1])? arr[1] : intervals[i][1];
            else
            {
                list.add(arr);
                arr = intervals[i];
            }
        }
        list.add(arr);
        return (list.toArray(new int[list.size()][]));
    }
}