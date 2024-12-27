class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0, n = heights.length;
        int[] Left = new int[n];
        int[] Right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            Left[i] = (stack.isEmpty())? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = (n - 1); i >= 0; i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            Right[i] = (stack.isEmpty())? n : stack.peek();
            stack.push(i);
        }
        for(int i = 0; i < n; i++)
        {
            int width = Right[i] - Left[i] - 1;
            max = Math.max(max,(heights[i] * width));
        }
        return max;
    }
}