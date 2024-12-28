class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i != s.length())
        {
            int size = stack.size();
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if(ch == ')')
            {
                if(size >= 1 && stack.peek() == '(')
                    stack.removeLast();
                else
                    stack.push(ch);
            }
            else if(ch == '}')
            {
                if(size >= 1 && stack.peek() == '{')
                    stack.removeLast();
                else
                    stack.push(ch);
            }
            else if(ch == ']')
            {
                if(size >= 1 && stack.peek() == '[')
                    stack.removeLast();
                else
                    stack.push(ch);
            }
            i++;
        }
        return stack.size();
    }
}