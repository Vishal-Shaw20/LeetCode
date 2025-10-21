class Solution {
    public int myAtoi(String s) 
    {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int flag = 1, i = 0;
        long sum = 0;
        char ch = s.charAt(0);
        if(!(Character.isDigit(ch) || ch == '-' || ch == '+'))
            return 0;
        else if(ch == '-' || ch == '+')
        {   
            flag = (ch == '+')? 1 : -1;
            i++;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i)))
        {
            sum = (sum * 10) + (s.charAt(i) - '0');
            if((sum * flag) < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else if((sum * flag) > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            i++;
        }
        return (int)(sum * flag);
    }
}