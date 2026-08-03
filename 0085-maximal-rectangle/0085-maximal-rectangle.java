class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] tempMatrix = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == '1')
                    tempMatrix[j]++;
                else
                    tempMatrix[j] = 0;
            }
            int temp = largestRectangleArea(tempMatrix);
            max = (temp > max)? temp : max;
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nse = NSE(heights);
        int[] pse = PSE(heights);
        int max = 0;
        for(int i = 0; i < heights.length; i++)
        {
            int temp = heights[i] * (nse[i] - pse[i] - 1);
            max = (temp > max)? temp : max;
        }
        return max;
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
                while(!stack.isEmpty() && stack.peek()[0] >= arr[i])
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