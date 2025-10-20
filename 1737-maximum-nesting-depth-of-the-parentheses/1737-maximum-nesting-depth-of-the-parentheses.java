class Solution {
    public int maxDepth(String s) 
    {
        int count = 0, max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                count++;
                max = (max > count)? max : count;
            }
            else if(ch == ')')
                count--;
        }
        return max;
    }
}