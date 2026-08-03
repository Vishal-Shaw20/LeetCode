class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int[] nse = NSE(arr);
        int[] pse = PSE(arr);
        int total = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (int)((total + ((long)left * right * arr[i]) % mod) % mod);
        }
        return total;
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
}