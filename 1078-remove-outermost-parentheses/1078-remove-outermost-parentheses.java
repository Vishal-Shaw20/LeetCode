class Solution {
    public String removeOuterParentheses(String s) 
    {
        StringBuilder final_str = new StringBuilder();
        int count = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                if(count > 0)
                    final_str.append(ch);
                count++;
            }
            else
            {
                count--;
                if(count > 0)
                    final_str.append(ch);
            }
        }
        return final_str.toString();
    }
}