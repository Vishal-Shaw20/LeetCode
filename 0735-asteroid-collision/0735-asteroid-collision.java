class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = 0, flag = 0;
        while(n != asteroids.length)
        {
            if(stack.isEmpty())
                stack.push(asteroids[n]);
            else
            {
                if((stack.peek() > 0 && asteroids[n] > 0) || (stack.peek() < 0 && asteroids[n] < 0) || (stack.peek() < 0 && asteroids[n] > 0))
                    stack.push(asteroids[n]);
                else
                {
                    while(!stack.isEmpty() && (stack.peek() > 0 && asteroids[n] < 0))
                    {
                        if(Math.abs(stack.peek()) < Math.abs(asteroids[n]))
                        {
                            flag = 0;
                            stack.pop();
                        }
                        else if(Math.abs(stack.peek()) > Math.abs(asteroids[n]))
                        {
                            flag = 1;
                            break;
                        }
                        else
                        {
                            flag = 1;
                            stack.pop();
                            break;
                        }
                    }
                    if(flag == 0)
                        stack.push(asteroids[n]);                    
                }
            }
            n++;
        }
        int[] ans = new int[stack.size()];
        while(!stack.isEmpty())
        {
            for(int i = stack.size() - 1; i >= 0; i--)
                ans[i] = stack.pop();
        }
        return ans;
    }
}