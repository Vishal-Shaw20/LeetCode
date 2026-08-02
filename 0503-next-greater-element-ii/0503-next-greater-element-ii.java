class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = ((2 * nums.length) - 1); i >= 0; i--)
        {
            int j = i % nums.length;
            if(!stack.isEmpty())
            {
                while(!stack.isEmpty() && stack.peek() <= nums[j])
                    stack.pop();
            }
            if(i < nums.length)
            {
                if(stack.isEmpty())
                    ans[i] = -1;
                else if(nums[i] < stack.peek())
                    ans[i] = stack.peek();
            }
            stack.push(nums[j]);
        }
        return ans;
    }
}