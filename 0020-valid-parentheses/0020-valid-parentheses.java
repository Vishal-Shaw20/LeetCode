class Solution {
    public boolean isValid(String s) {
        if((s.length() & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        boolean t = false;
        while(i != s.length())
        {
            int size = stack.size();
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if(size >= 1 && ch == ')' && stack.peek() == '(')
                stack.removeLast();
            else if(size >= 1 && ch == '}' && stack.peek() == '{')
                stack.removeLast();
            else if(size >= 1 && ch == ']' && stack.peek() == '[')
                stack.removeLast();
            else
                return false;
            i++;
        }
        return stack.isEmpty();
    }
}