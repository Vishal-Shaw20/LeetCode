class Solution {
    public long subArrayRanges(int[] nums) {
        int[] nse = NSE(nums);
        int[] pse = PSE(nums);
        int[] nge = NGE(nums);
        int[] pge = PGE(nums);
        long totalMin = 0, totalMax = 0;
        for(int i = 0; i < nums.length; i++)
        {
            long left = i - pse[i];
            long right = nse[i] - i;
            totalMin += left * right * nums[i];
            left = i - pge[i];
            right = nge[i] - i;
            totalMax += left * right * nums[i];
        }
        return (totalMax - totalMin);
    }
    public int[] NSE(int[] arr)
    {
        int[] nse = new int[arr.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(stack.isEmpty())
                nse[i] = arr.length;
            else
            {
                while(!stack.isEmpty() && stack.peek()[0] >= arr[i])
                    stack.pop();
                if(stack.isEmpty())
                    nse[i] = arr.length;
                else
                    nse[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i});
        }
        return nse;
    }
    public int[] PSE(int[] arr)
    {
        int[] pse = new int[arr.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(stack.isEmpty())
                pse[i] = -1;
            else
            {
                while(!stack.isEmpty() && stack.peek()[0] > arr[i])
                    stack.pop();
                if(stack.isEmpty())
                    pse[i] = -1;
                else
                    pse[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i});
        }
        return pse;
    }
    public int[] NGE(int[] arr)
    {
        int[] nge = new int[arr.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(stack.isEmpty())
                nge[i] = arr.length;
            else
            {
                while(!stack.isEmpty() && stack.peek()[0] <= arr[i])
                    stack.pop();
                if(stack.isEmpty())
                    nge[i] = arr.length;
                else
                    nge[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i});
        }
        return nge;
    }
    public int[] PGE(int[] arr)
    {
        int[] pge = new int[arr.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(stack.isEmpty())
                pge[i] = -1;
            else
            {
                while(!stack.isEmpty() && stack.peek()[0] < arr[i])
                    stack.pop();
                if(stack.isEmpty())
                    pge[i] = -1;
                else
                    pge[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i],i});
        }
        return pge;
    }
}