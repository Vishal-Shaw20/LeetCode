class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length())
            return "0";
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < num.length(); i++)
        {
            int n = num.charAt(i) - '0';
            while(!stack.isEmpty() && n < stack.peek() && k > 0)
            {
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        char[] ans = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = (char)(stack.pop() + '0');
        }
        String s = new String(ans, 0, ans.length - k);
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0')
            i++;
        return (i == s.length())? "0" : s.substring(i);
    }
}