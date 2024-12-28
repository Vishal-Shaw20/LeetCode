class Solution {
    public int minInsertions(String s) {
        int openCount = 0;
        int insert = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
                openCount++;
            else
            {
                if((i + 1) < s.length() && s.charAt(i + 1) == ')')
                    i++;
                else
                    insert++;
                if(openCount > 0)
                    openCount--;
                else
                    insert++;
            }
        }
        insert+= (2 * openCount);
        return insert;
    }
}